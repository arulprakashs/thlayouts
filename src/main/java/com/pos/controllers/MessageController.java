package com.pos.controllers;

import com.pos.account.Account;
import com.pos.account.AccountRepository;
import com.pos.message.Address;
import com.pos.message.AddressRepository;
import com.pos.message.Message;
import com.pos.message.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

/**
 * Tiles Dialect usage example.
 */
@Controller 
@Secured("ROLE_USER")
class MessageController {

    private MessageRepository messageRepository;
    private AddressRepository addressRepository;

    @Autowired
    public MessageController(MessageRepository messageRepository,AddressRepository addressRepository) {
        this.messageRepository = messageRepository;
        this.addressRepository = addressRepository;
        //init();
    }

    private void init() {
        Address address1 = new Address("street 91",520935);
        Address address2 = new Address("street 92",520935);
        messageRepository.save(new Message("What's up?", "This is a what's up message..."));
        messageRepository.save(new Message("How is going?", "This is a how's going message..."));
        addressRepository.save(address1);
        addressRepository.save(address2);
    }

    @ModelAttribute("page")
    public String module() {
        return "messages";
    }

    @RequestMapping(value = "message", method = RequestMethod.GET)
    public String messages(Model model) {
        model.addAttribute("messages", messageRepository.findAll());
        // the view will match 'messages/*'; see /WEB-INF/views/message/tiles-defs.xml
        return "message/list";
    }
}
