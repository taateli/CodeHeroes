package app.controller;

import app.domain.Article;
import app.domain.Book;
import app.domain.Inproceedings;
import app.domain.Reference;
import app.service.ReferenceService;
import app.service.ValidatorService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*
This class handles all requests related to Reference -classes

 */
@Controller
public class ReferenceController {

    // To controller is given an instance of service class
    @Autowired
    private ReferenceService refService;
    
    @Autowired
    private ValidatorService validator;

    //This method handles get-request to home path and shows home.html file from folder resource/templates/ 
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showReferenceTypes(Model model) {
        List<Reference> refs = refService.getReferences();
        model.addAttribute("references", refs);
        model.addAttribute("newReference", model.asMap().get("newReference"));
        return "home";
    }

    //This method handles get-request to path /books and shows books.html file from folder resource/templates/ 
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String showBooksForm(Model model) {
        Book b = new Book();
        model.addAttribute("book", b);
        return "books";
    }

    //This method handles get-request to path /inproceedings and shows inproceedings.html file from folder resource/templates/ 
    @RequestMapping(value = "/inproceedings", method = RequestMethod.GET)
    public String showInpForm(Model model) {
        Inproceedings inp = new Inproceedings();
        model.addAttribute("inproceedings", inp);
        
        return "inproceedings";
    }
    
     //This method handles get-request to path /article and shows books.html file from folder resource/templates/ 
    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public String showArticleForm(Model model) {
        Article article = new Article();
        model.addAttribute("article", article);
        
        return "article";
    }


    /*  This method handles post-request to path /inproceedings
        and takes Inproceedings type parameter. It uses @ModelAttribute annotation to render
        th:field tags from view
    
     */
    @RequestMapping(value = "/inproceedings", method = RequestMethod.POST)
    public String addInproceedings(Model model, @Valid @ModelAttribute Inproceedings inp, BindingResult bindingresult,
                                    RedirectAttributes redirectAttrs) {
        
        if (bindingresult.hasErrors()) {
            return "inproceedings";
        }

        if(validator.fieldNotEmpty(inp.getEndingPage()) && validator.fieldNotEmpty(inp.getStartingPage())) {
                if(validator.endingPageBeforeStartingPage(inp.getEndingPage(), inp.getStartingPage())){
                    bindingresult.addError(new FieldError("Inproceedings", "endingPage", "Ending page cannot be before starting page!"));
                    return "inproceedings";
                }    
        }
        inp.setAuthors(validator.splitAuthors(inp.getAuthors().get(0)));
        Reference r = null;
        if (!validator.fieldNotEmpty(inp.getKey())) {
            r = refService.addReference(validator.getKey(inp));
        } else {
            r = refService.addReference(inp);
        }
        
        redirectAttrs.addFlashAttribute("newReference", r);
        return "redirect:/";
    }

    /*  This method handles post-request to path /books
        and takes Books type parameter. It uses @ModelAttribute annotation to render
        th:field tags from view
    
     */
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String addBook(Model model, @Valid @ModelAttribute Book book, BindingResult bindingresult,
                            RedirectAttributes redirectAttrs) {
        
        if (bindingresult.hasErrors()) {
            return "books";
        }
        book.setAuthors(validator.splitAuthors(book.getAuthors().get(0)));
        Reference r = null;
        if (!validator.fieldNotEmpty(book.getKey())) {
            r = refService.addReference(validator.getKey(book));
        } else {
            r = refService.addReference(book);
        }
        redirectAttrs.addFlashAttribute("newReference", r);
        return "redirect:/";
    }
    
    /*  This method handles post-request to path /article
        and takes Article type parameter. It uses @ModelAttribute annotation to render
        th:field tags from view
    
     */
    @RequestMapping(value = "/article", method = RequestMethod.POST)
    public String addArticle(Model model, @Valid @ModelAttribute Article article, BindingResult bindingresult,
                            RedirectAttributes redirectAttrs) {
        
        if (bindingresult.hasErrors()) {
            return "article";
        }
        if (validator.fieldNotEmpty(article.getEndingPage()) && validator.fieldNotEmpty(article.getStartingPage())) {
                if(validator.endingPageBeforeStartingPage(article.getEndingPage(), article.getStartingPage())){
                    bindingresult.addError(new FieldError("Article", "endingPage", "Ending page cannot be before starting page!"));
                    return "article";
                }    
        }
        article.setAuthors(validator.splitAuthors(article.getAuthors().get(0)));
        Reference r = null;
        if (!validator.fieldNotEmpty(article.getKey())) {
            r = refService.addReference(validator.getKey(article));
        } else {
            r = refService.addReference(article);
        }
        redirectAttrs.addFlashAttribute("newReference", r);
        return "redirect:/";
    }

    @RequestMapping(value = "/references/{id}", method = RequestMethod.DELETE)
    public String deleteReference(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        
        refService.delete(id);
        
        redirectAttrs.addFlashAttribute("delete", id);
        return "redirect:/";

    }
    
    @RequestMapping(value = "/references/{id}", method = RequestMethod.GET)
    public String editReference(Model model, @PathVariable Long id) {
        List<Reference> refs = refService.getReferences();
        model.addAttribute("references", refs);
        model.addAttribute("newReference", model.asMap().get("newReference"));
        return "home";
    }
    
}
