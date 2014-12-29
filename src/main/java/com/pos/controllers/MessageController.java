package com.pos.controllers;

import com.pos.message.Address;
import com.pos.message.AddressRepository;
import com.pos.message.Message;
import com.pos.message.MessageRepository;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        ObjectMapper mapper = new ObjectMapper();
        try {
            model.addAttribute("messages", mapper.writeValueAsString(messageRepository.findAll()));
        } catch (JsonGenerationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // the view will match 'messages/*'; see /WEB-INF/views/message/tiles-defs.xml
        return "message/list";
    }
}
