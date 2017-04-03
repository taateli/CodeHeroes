
package app.controller;

import app.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReferenceController {
    
    @Autowired
    private ReferenceService refService;
    
//    @RequestMapping(value = "/book", method = RequestMethod.POST)
//    public void addBook(@ModelAttribute Book book){
//        refService.addBookReference(book);
//    }
    
}
