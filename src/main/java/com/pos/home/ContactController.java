package com.pos.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
    
    public static Logger logger = LoggerFactory.getLogger(ContactController.class);
    
    @RequestMapping("contact")
    public String contactForm() {
        return "home/contact :: form";
    }
}
