package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class handles all requests which hasn't got any specific path-controller
 *
 */
@Controller
public class DefaultController {

    /**
     * This method shows home.html file from folder resource/templates/ if
     * necessary
     *
     * @return
     */
    @RequestMapping("*")
    public String handleDefault() {
        return "home";
    }

}
