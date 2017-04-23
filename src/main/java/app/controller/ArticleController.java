//package app.controller;
//
//import app.domain.Article;
//import app.domain.Reference;
//import app.service.ReferenceService;
//import app.service.ValidatorService;
//import javax.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//@Controller
//public class ArticleController {
//
//    @Autowired
//    private ReferenceService refService;
//
//    @Autowired
//    private ValidatorService validator;
//
//    //This method handles get-request to path /article and shows books.html file from folder resource/templates/ 
//    @RequestMapping(value = "/article", method = RequestMethod.GET)
//    public String showArticleForm(Model model) {
//        Article article = new Article();
//        model.addAttribute("article", article);
//
//        return "article";
//    }
//
//    /*  This method handles post-request to path /article
//        and takes Article type parameter. It uses @ModelAttribute annotation to render
//        th:field tags from view
//    
//     */
//    @RequestMapping(value = "/article", method = RequestMethod.POST)
//    public String addArticle(@Valid @ModelAttribute Article article, BindingResult bindingresult,
//            RedirectAttributes redirectAttrs) {
//
//        if (bindingresult.hasErrors()) {
//            return "article";
//        }
//        if (validator.fieldNotEmpty(article.getEndingPage()) && validator.fieldNotEmpty(article.getStartingPage())) {
//            if (validator.endingPageBeforeStartingPage(article.getEndingPage(), article.getStartingPage())) {
//                bindingresult.addError(new FieldError("Article", "endingPage", "Ending page cannot be before starting page!"));
//                return "article";
//            }
//        }
//        article.setAuthors(validator.splitAuthors(article.getAuthors().get(0)));
//        Reference r = null;
//        if (!validator.fieldNotEmpty(article.getKey())) {
//            r = refService.addReference(validator.getKey(article));
//        } else {
//            r = refService.addReference(article);
//        }
//        redirectAttrs.addFlashAttribute("newReference", r);
//        return "redirect:/";
//    }
//}
