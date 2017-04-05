
package app.controller;

import app.domain.Book;
import app.domain.Inproceedings;
import app.domain.Reference;
import app.service.ReferenceService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReferenceController {
    
    @Autowired
    private ReferenceService refService;
    
     @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showReferenceTypes(Model model) {
        List<String> referencetypes = new ArrayList<>();
        referencetypes.add("Book");
        referencetypes.add("Inproceedings");
        model.addAttribute("referencetypes", referencetypes);
        return "home";
    }
    
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String showBooksForm(Model model) {
        Book b = new Book();
        model.addAttribute("book",b);
        model.addAttribute("newReference",null);
        return "books";
    }
    
    @RequestMapping(value = "/inproceedings", method = RequestMethod.GET)
    public String showInpForm(Model model) {
        Inproceedings inp = new Inproceedings();
        model.addAttribute("inproceedings",inp);
        model.addAttribute("newReference",null);
        return "inproceedings";
    }
    
    @RequestMapping(value = "/inproceedings", method = RequestMethod.POST)
    public String addBook(Model model, @ModelAttribute Inproceedings inp){
        Reference r = refService.addReference(inp);
        model.addAttribute("newReference",r);
        return "inproceedings";
    }
    
     @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String addInproceedings(Model model, @ModelAttribute Book book){
        Reference r = refService.addReference(book);
        model.addAttribute("newReference",r);
        return "books";
    }
    
   
    
}
