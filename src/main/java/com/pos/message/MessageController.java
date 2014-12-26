package com.pos.message;

import com.pos.account.Account;
import com.pos.account.AccountRepository;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.security.Principal;
import java.util.Calendar;
import java.util.Date;

/**
 * Tiles Dialect usage example.
 */
@Controller
@Secured("ROLE_USER")
class MessageController {

    private MessageRepository messageRepository;
    
    private PersonRepository personRepository;
    
    @Autowired
    public MessageController(MessageRepository messageRepository,PersonRepository personRepository) {
        this.messageRepository = messageRepository;
        this.personRepository = personRepository;
        init();
    }
    
    
    private void init() {
        Calendar cal = Calendar.getInstance();        
        messageRepository.save(new Message("What's up?", "This is a what's up message..."));
        messageRepository.save(new Message("How is going?", "This is a how's going message..."));
        personRepository.save(new Person("Bob",12));
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
