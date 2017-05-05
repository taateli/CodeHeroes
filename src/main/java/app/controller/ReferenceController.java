package app.controller;

import app.domain.Article;
import app.domain.Book;
import app.domain.Inproceedings;
import app.domain.Reference;
import app.service.ReferenceService;
import app.service.UtilityService;
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

/**
 * This class handles all requests related to Reference -classes
 *
 */
@Controller
public class ReferenceController {

    // To controller is given an instance of service class
    @Autowired
    private ReferenceService refService;

    @Autowired
    private UtilityService utilService;

    /**
     * This method handles get-request to path /acm
     *
     * @param model Model object
     * @return path acm
     */
    @RequestMapping(value = "/acm", method = RequestMethod.GET)
    public String showAcmForm(Model model) {
        return "acm";
    }

    /**
     * This method adds a reference from ACM to the database
     *
     * @param model Model object
     * @param url String url of a reference from ACM
     * @param redirectAttrs RedirectAttributes
     * @return path redirect
     * @throws InterruptedException if interrupted
     */
    @RequestMapping(value = "/acm", method = RequestMethod.POST)
    public String getFromAcm(Model model, @RequestParam String url, RedirectAttributes redirectAttrs) throws InterruptedException {
        Reference newReference = refService.getReferencesFromAcm(url);
        if (newReference == null) {
            model.addAttribute("url", url);
            model.addAttribute("errormessage", "Link you gave didn't return any references. Check your link!");
            return "acm";
        }
        refService.addReference(refService.getReferencesFromAcm(url));
        redirectAttrs.addFlashAttribute("newReference", newReference);
        return "redirect:/";
    }

    /**
     * This method handles get-request to home path and shows home.html file
     * from folder resource/templates/
     *
     * @param model Model object
     * @return path home
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showReferenceTypes(Model model) {
        List<Reference> refs = refService.getReferences();
        model.addAttribute("references", refs);
        model.addAttribute("newReference", model.asMap().get("newReference"));
        return "home";
    }

    /**
     * This method handles get-request to path /books and shows books.html file
     * from folder resource/templates/
     *
     * @param model Model object
     * @return path books
     */
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String showBooksForm(Model model) {
        Book b = new Book();
        model.addAttribute("book", b);
        return "books";
    }

    /**
     * This method handles get-request to path /inproceedings and shows
     * inproceedings.html file from folder resource/templates/
     *
     * @param model Model object
     * @return path inproceedings
     */
    @RequestMapping(value = "/inproceedings", method = RequestMethod.GET)
    public String showInpForm(Model model) {
        Inproceedings inp = new Inproceedings();
        model.addAttribute("inproceedings", inp);
        return "inproceedings";
    }

    /**
     * This method handles get-request to path /article and shows books.html
     * file from folder resource/templates/
     *
     * @param model Model object
     * @return path article
     */
    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public String showArticleForm(Model model) {
        Article article = new Article();
        model.addAttribute("article", article);
        return "article";
    }

    /**
     * This method handles post-request to path /inproceedings and takes
     * Inproceedings type parameter. It uses @ModelAttribute annotation to
     * render th:field tags from view
     *
     * @param inp Inproceedings object
     * @param bindingresult BindingResult
     * @param redirectAttrs RedirectAttributes
     * @return either path inproceedings or redirect to the home page if no
     * errors
     */
    @RequestMapping(value = "/inproceedings", method = RequestMethod.POST)
    public String addInproceedings(@Valid @ModelAttribute Inproceedings inp, BindingResult bindingresult,
            RedirectAttributes redirectAttrs) {

        if (bindingresult.hasErrors()) {
            return "inproceedings";
        }

        if (!utilService.pageOrderOk(inp.getEndingPage(), inp.getStartingPage())) {
            bindingresult.addError(new FieldError("Inproceedings", "endingPage", "Ending page cannot be before starting page!"));
            return "inproceedings";
        }

        addReference(inp, bindingresult, redirectAttrs);
        return "redirect:/";
    }

    /**
     * This method handles post-request to path /books and takes Books type
     * parameter. It uses @ModelAttribute annotation to render th:field tags
     * from view
     *
     * @param book Book object being added
     * @param bindingresult BindingResult
     * @param redirectAttrs RedirectAttributes
     * @return either path books or redirect to the home page if no errors
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

    /**
     * This method handles post-request to path /article and takes Article type
     * parameter. It uses @ModelAttribute annotation to render th:field tags
     * from view
     *
     * @param article Article object being added
     * @param bindingresult BindingResult
     * @param redirectAttrs RedirectAttributes
     * @return either path article or redirect to the home page if no errors
     */
    @RequestMapping(value = "/article", method = RequestMethod.POST)
    public String addArticle(@Valid @ModelAttribute Article article, BindingResult bindingresult,
            RedirectAttributes redirectAttrs) {

        if (bindingresult.hasErrors()) {
            return "article";
        }
        if (!utilService.pageOrderOk(article.getEndingPage(), article.getStartingPage())) {
            bindingresult.addError(new FieldError("Article", "endingPage", "Ending page cannot be before starting page!"));
            return "article";
        }
        addReference(article, bindingresult, redirectAttrs);
        return "redirect:/";
    }

    /**
     * This method takes search -String to compare it on all references toString
     * -methods and return all references including the String
     *
     * @param model Model object
     * @param search - field for any string to search from references
     * @return path home
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
     * @param reference Reference being added
     * @param bindingresult BindingResult
     * @param redirectAttrs RedirectAttributes
     */
    private void addReference(@Valid
            @ModelAttribute Reference reference, BindingResult bindingresult,
            RedirectAttributes redirectAttrs) {

        reference.setAuthors(utilService.fixAuthors(reference.getAuthors()));

        Reference newReference = null;
        if (!utilService.fieldNotEmpty(reference.getKey())) {
            newReference = refService.addReference(utilService.getKey(reference));
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
     * @param redirectAttrs RedirectAttributes
     * @return redirect to the home page
     */
    @RequestMapping(value = "/references/{id}", method = RequestMethod.DELETE)
    public String deleteReference(@PathVariable Long id, RedirectAttributes redirectAttrs) {

        refService.delete(id);

        redirectAttrs.addFlashAttribute("delete", id);
        return "redirect:/";

    }

    /**
     * Method for updating a Book type reference
     *
     * @param editBookRef, Book object containing updated information
     * @param bindingresult BindingResult
     * @param id, Long, id of the Book reference being updated
     * @param redirectAttrs RedirectAttributes
     * @return redirect to the main page
     */
    @RequestMapping(value = "/editBook/{id}", method = RequestMethod.POST)
    public String updateBook(@Valid @ModelAttribute Book editBookRef, BindingResult bindingresult,
            @PathVariable Long id, RedirectAttributes redirectAttrs) {

        if (bindingresult.hasErrors()) {
            return "editBook";
        }

        Book editedBook = (Book) refService.findById(id);

        editedBook.setAuthors(utilService.fixAuthors(editBookRef.getAuthors()));
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
        redirectAttrs.addFlashAttribute("updatedReference", editedBook);
        return "redirect:/";
    }

    /**
     * Method for updating an Article type reference
     *
     * @param editArticleRef, Article object containing updated information
     * @param bindingresult BindingResult
     * @param id, Long, id of the Article reference being updated
     * @param redirectAttrs RedirectAttributes
     * @return redirect to the main page
     */
    @RequestMapping(value = "/editArticle/{id}", method = RequestMethod.POST)
    public String updateArticle(@Valid @ModelAttribute Article editArticleRef, BindingResult bindingresult,
            @PathVariable Long id, RedirectAttributes redirectAttrs) {

        if (bindingresult.hasErrors()) {
            return "editArticle";
        }

        Article editedArticle = (Article) refService.findById(id);

        editedArticle.setAuthors(utilService.fixAuthors(editArticleRef.getAuthors()));
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
        redirectAttrs.addFlashAttribute("updatedReference", editedArticle);
        return "redirect:/";
    }

    /**
     * Method for updating an Inproceedings type reference
     *
     * @param editInproceedingsRef, Inproceedings object containing updated
     * information
     * @param bindingresult BindingResult
     * @param id, Long, id of the Inproceedings reference being updated
     * @param redirectAttrs RedirectAttributes
     * @return redirect to the main page
     */
    @RequestMapping(value = "/editInpro/{id}", method = RequestMethod.POST)
    public String updateInproceedings(@Valid @ModelAttribute Inproceedings editInproceedingsRef, BindingResult bindingresult,
            @PathVariable Long id, RedirectAttributes redirectAttrs) {

        if (bindingresult.hasErrors()) {
            return "editInpro";
        }

        Inproceedings editedInproceed = (Inproceedings) refService.findById(id);

        editedInproceed.setAuthors(utilService.fixAuthors(editInproceedingsRef.getAuthors()));
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
        redirectAttrs.addFlashAttribute("updatedReference", editedInproceed);
        return "redirect:/";
    }

    /**
     * Method for editing Reference objects
     *
     * @param model Model object
     * @param id, Long, id of the reference being edited
     * @return a specific editing page according to the type of the reference
     */
    @RequestMapping(value = "/references/{id}", method = RequestMethod.GET)
    public String editReference(Model model, @PathVariable Long id) {
        Reference reference = refService.findById(id);

        // places 'and' between authors
        String authors = reference.authorsToBibTex();
        List<String> authorsList = new ArrayList<>();
        authorsList.add(authors);
        reference.setAuthors(authorsList); //new list in the first index

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
