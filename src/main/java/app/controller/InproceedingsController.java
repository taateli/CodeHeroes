//package app.controller;
//
//import app.domain.Inproceedings;
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
//public class InproceedingsController {
//
//    // To controller is given an instance of service class
//    @Autowired
//    private ReferenceService refService;
//
//    @Autowired
//    private ValidatorService validator;
//
//    //This method handles get-request to path /inproceedings and shows inproceedings.html file from folder resource/templates/ 
//    @RequestMapping(value = "/inproceedings", method = RequestMethod.GET)
//    public String showInpForm(Model model) {
//        Inproceedings inp = new Inproceedings();
//        model.addAttribute("inproceedings", inp);
//
//        return "inproceedings";
//    }
//
//    /*  This method handles post-request to path /inproceedings
//        and takes Inproceedings type parameter. It uses @ModelAttribute annotation to render
//        th:field tags from view
//    
//     */
//    @RequestMapping(value = "/inproceedings", method = RequestMethod.POST)
//    public String addInproceedings(@Valid @ModelAttribute Inproceedings inp, BindingResult bindingresult,
//            RedirectAttributes redirectAttrs) {
//
//        if (bindingresult.hasErrors()) {
//            return "inproceedings";
//        }
//
//        if (validator.fieldNotEmpty(inp.getEndingPage()) && validator.fieldNotEmpty(inp.getStartingPage())) {
//            if (validator.endingPageBeforeStartingPage(inp.getEndingPage(), inp.getStartingPage())) {
//                bindingresult.addError(new FieldError("Inproceedings", "endingPage", "Ending page cannot be before starting page!"));
//                return "inproceedings";
//            }
//        }
//        inp.setAuthors(validator.splitAuthors(inp.getAuthors().get(0)));
//        Reference r = null;
//        if (!validator.fieldNotEmpty(inp.getKey())) {
//            r = refService.addReference(validator.getKey(inp));
//        } else {
//            r = refService.addReference(inp);
//        }
//
//        redirectAttrs.addFlashAttribute("newReference", r);
//        return "redirect:/";
//    }
//}
