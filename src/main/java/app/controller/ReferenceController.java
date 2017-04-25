package app.controller;

import app.domain.Article;
import app.domain.Book;
import app.domain.Inproceedings;
import app.domain.Reference;
import app.service.ReferenceService;
import app.service.ValidatorService;
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
    public String addInproceedings(@Valid @ModelAttribute Inproceedings inp, BindingResult bindingresult,
            RedirectAttributes redirectAttrs) {

        if (bindingresult.hasErrors()) {
            return "inproceedings";
        }

        if (validator.fieldNotEmpty(inp.getEndingPage()) && validator.fieldNotEmpty(inp.getStartingPage())) {
            if (validator.endingPageBeforeStartingPage(inp.getEndingPage(), inp.getStartingPage())) {
                bindingresult.addError(new FieldError("Inproceedings", "endingPage", "Ending page cannot be before starting page!"));
                return "inproceedings";
            }
        }
        addReference(inp, bindingresult, redirectAttrs);
        return "redirect:/";
    }

    /*  This method handles post-request to path /books
        and takes Books type parameter. It uses @ModelAttribute annotation to render
        th:field tags from view
    
     */
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String addBook(@Valid @ModelAttribute Book book, BindingResult bindingresult,
            RedirectAttributes redirectAttrs) {

        if (bindingresult.hasErrors()) {
            return "books";
        }
        addReference(book, bindingresult, redirectAttrs);
        return "redirect:/";
    }

    /*  This method handles post-request to path /article
        and takes Article type parameter. It uses @ModelAttribute annotation to render
        th:field tags from view
    
     */
    @RequestMapping(value = "/article", method = RequestMethod.POST)
    public String addArticle(@Valid @ModelAttribute Article article, BindingResult bindingresult,
            RedirectAttributes redirectAttrs) {

        if (bindingresult.hasErrors()) {
            return "article";
        }
        if (validator.fieldNotEmpty(article.getEndingPage()) && validator.fieldNotEmpty(article.getStartingPage())) {
            if (validator.endingPageBeforeStartingPage(article.getEndingPage(), article.getStartingPage())) {
                bindingresult.addError(new FieldError("Article", "endingPage", "Ending page cannot be before starting page!"));
                return "article";
            }
        }
        addReference(article, bindingresult, redirectAttrs);
        return "redirect:/";
    }

    /**
     * This method takes search -String to compare it on all references toString
     * -methods and return all references including the String
     *
     * @param model
     * @param search - field for any string to search from references
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchReference(Model model, @RequestParam String search) {
        List<Reference> refs = refService.getSearchedReferences(search);
        model.addAttribute("references", refs);
        model.addAttribute("newReference", model.asMap().get("newReference"));
        return "home";
    }

    /**
     * A method to help with adding a reference into the database
     *
     * @param reference
     * @param bindingresult
     * @param redirectAttrs
     */
    private void addReference(@Valid
            @ModelAttribute Reference reference, BindingResult bindingresult,
            RedirectAttributes redirectAttrs) {

        reference.setAuthors(validator.splitAuthors(reference.getAuthors().get(0)));
        Reference newReference = null;
        if (!validator.fieldNotEmpty(reference.getKey())) {
            newReference = refService.addReference(validator.getKey(reference));
        } else {
            newReference = refService.addReference(reference);
        }
        redirectAttrs.addFlashAttribute("newReference", newReference);
    }

    /**
     * Method for deleting a reference
     *
     * @param id, Long, received as a parameter, id of the reference being
     * deleted
     * @param redirectAttrs
     * @return
     */
    @RequestMapping(value = "/references/{id}", method = RequestMethod.DELETE)
    public String deleteReference(@PathVariable Long id, RedirectAttributes redirectAttrs) {

        refService.delete(id);

        redirectAttrs.addFlashAttribute("delete", id);
        return "redirect:/";

    }

    @RequestMapping(value = "/editBook/{id}", method = RequestMethod.POST)
    public String updateBook(@Valid @ModelAttribute Book editBookRef, BindingResult bindingresult,
            @PathVariable Long id) {

        if (bindingresult.hasErrors()) {
            return "editBook";
        }

        Book editedBook = (Book) refService.findById(id);

        editedBook.setAuthors(validator.splitAuthors(editBookRef.getAuthors().get(0)));
        editedBook.setKey(editBookRef.getKey());
        editedBook.setTags(editBookRef.getTags());
        editedBook.setTitle(editBookRef.getTitle());
        editedBook.setYear(editBookRef.getYear());
        editedBook.setAddress(editBookRef.getAddress());
        editedBook.setEdition(editBookRef.getEdition());
        editedBook.setMonth(editBookRef.getMonth());
        editedBook.setPublisher(editBookRef.getPublisher());
        editedBook.setSeries(editBookRef.getSeries());
        editedBook.setVolume(editBookRef.getVolume());
        refService.addReference(editedBook);
        return "redirect:/";
    }

    @RequestMapping(value = "/editArticle/{id}", method = RequestMethod.POST)
    public String updateArticle(@Valid @ModelAttribute Article editArticleRef, BindingResult bindingresult,
            @PathVariable Long id) {

        if (bindingresult.hasErrors()) {
            return "editArticle";
        }

        Article editedArticle = (Article) refService.findById(id);

        editedArticle.setAuthors(validator.splitAuthors(editArticleRef.getAuthors().get(0)));
        editedArticle.setKey(editArticleRef.getKey());
        editedArticle.setTags(editArticleRef.getTags());
        editedArticle.setTitle(editArticleRef.getTitle());
        editedArticle.setYear(editArticleRef.getYear());
        editedArticle.setAddress(editArticleRef.getAddress());
        editedArticle.setJournal(editArticleRef.getJournal());
        editedArticle.setNumber(editArticleRef.getNumber());
        editedArticle.setStartingPage(editArticleRef.getStartingPage());
        editedArticle.setEndingPage(editArticleRef.getEndingPage());
        editedArticle.setMonth(editArticleRef.getMonth());
        editedArticle.setPublisher(editArticleRef.getPublisher());
        editedArticle.setVolume(editArticleRef.getVolume());
        refService.addReference(editedArticle);
        return "redirect:/";
    }

    @RequestMapping(value = "/editInpro/{id}", method = RequestMethod.POST)
    public String updateInproceedings(@Valid @ModelAttribute Inproceedings editInproceedingsRef, BindingResult bindingresult,
            @PathVariable Long id) {

        if (bindingresult.hasErrors()) {
            return "editInpro";
        }

        Inproceedings editedInproceed = (Inproceedings) refService.findById(id);

        editedInproceed.setAuthors(validator.splitAuthors(editInproceedingsRef.getAuthors().get(0)));
        editedInproceed.setKey(editInproceedingsRef.getKey());
        editedInproceed.setTags(editInproceedingsRef.getTags());
        editedInproceed.setTitle(editInproceedingsRef.getTitle());
        editedInproceed.setYear(editInproceedingsRef.getYear());
        editedInproceed.setAddress(editInproceedingsRef.getAddress());
        editedInproceed.setBookTitle(editInproceedingsRef.getBookTitle());
        editedInproceed.setEditor(editInproceedingsRef.getEditor());
        editedInproceed.setOrganization(editInproceedingsRef.getOrganization());
        editedInproceed.setSeries(editInproceedingsRef.getSeries());
        editedInproceed.setStartingPage(editInproceedingsRef.getStartingPage());
        editedInproceed.setEndingPage(editInproceedingsRef.getEndingPage());
        editedInproceed.setMonth(editInproceedingsRef.getMonth());
        editedInproceed.setPublisher(editInproceedingsRef.getPublisher());
        editedInproceed.setVolume(editInproceedingsRef.getVolume());
        refService.addReference(editedInproceed);
        return "redirect:/";
    }

    @RequestMapping(value = "/references/{id}", method = RequestMethod.GET)
    public String editReference(Model model, @PathVariable Long id) {
        Reference reference = refService.findById(id);

        if (reference instanceof Book) {
            model.addAttribute("book", reference);
            return "editBook";

        } else if (reference instanceof Article) {
            model.addAttribute("article", reference);
            return "editArticle";
        } else {
            model.addAttribute("inproceedings", reference);
            return "editInpro";
        }
    }

}
