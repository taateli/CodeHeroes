
package app.controller;

import app.domain.Book;
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
    
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public void addBook(@ModelAttribute Book book){
        refService.addBookReference(book);
    }
    
        @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showReferenceTypes(Model model) {
        List<String> referencetypes = new ArrayList<String>();
        referencetypes.add("Book");
        referencetypes.add("Inproceedings");
        model.addAttribute("referencetypes", referencetypes);
        return "home";
    }
    
}
