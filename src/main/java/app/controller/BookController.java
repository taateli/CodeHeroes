//package app.controller;
//
//import app.domain.Book;
//import app.domain.Reference;
//import app.service.ReferenceService;
//import app.service.ValidatorService;
//import javax.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//@Controller
//public class BookController {
//
//    @Autowired
//    private ReferenceService refService;
//
//    @Autowired
//    private ValidatorService validator;
//
//    //This method handles get-request to path /books and shows books.html file from folder resource/templates/ 
//    @RequestMapping(value = "/books", method = RequestMethod.GET)
//    public String showBooksForm(Model model) {
//        Book b = new Book();
//        model.addAttribute("book", b);
//        return "books";
//    }
//
//    /*  This method handles post-request to path /books
//        and takes Books type parameter. It uses @ModelAttribute annotation to render
//        th:field tags from view
//    
//     */
//    @RequestMapping(value = "/books", method = RequestMethod.POST)
//    public String addBook(@Valid @ModelAttribute Book book, BindingResult bindingresult,
//            RedirectAttributes redirectAttrs) {
//
//        if (bindingresult.hasErrors()) {
//            return "books";
//        }
//        book.setAuthors(validator.splitAuthors(book.getAuthors().get(0)));
//        Reference r = null;
//        if (!validator.fieldNotEmpty(book.getKey())) {
//            r = refService.addReference(validator.getKey(book));
//        } else {
//            r = refService.addReference(book);
//        }
//        redirectAttrs.addFlashAttribute("newReference", r);
//        return "redirect:/";
//    }
//
//}
