package com.pos.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.security.Principal;

@Controller
public class HomeController {

    public static Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    @ModelAttribute("page")
    public String module() {
        return "home";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Principal principal) {
        logger.debug("Entering index");
        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
    }
}
