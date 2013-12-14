package com.dozortsev.bookstore.controller;

import com.dozortsev.bookstore.data.BookRepo;
import com.dozortsev.bookstore.data.ClientRepo;
import com.dozortsev.bookstore.model.Client;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import static com.dozortsev.bookstore.util.Util.isClientValid;
import static com.dozortsev.bookstore.util.Util.removeAll;
import static java.lang.String.format;
import static org.apache.log4j.Logger.getLogger;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LoginController {

    private final static Logger log = getLogger(LoginController.class);

    @Autowired
    BookRepo bookRepo;
    @Autowired
    ClientRepo clientRepo;

    @ModelAttribute("client")
    public Client client(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String pwd) {

        log.info(format("Client data; Id: %s, Email: %s, Password: %s.", id, email, pwd));

        if (id != null) return clientRepo.load(id);

        if (email != null && pwd != null)
            return clientRepo.authentication(email, pwd);

        log.info("Create new Client instance.");
        return new Client();
    }

    @RequestMapping(value = "/Welcome", method = POST)
    public ModelAndView signIn(@ModelAttribute("client") Client client) {

        log.info("In signIn method.");

        if (client == null)
            return new ModelAndView("redirect:/SignIn");

        log.info("Client not null.");

        if (isClientValid(client)) {

            log.info("Client valid.");
            clientRepo.save(client);
        }
        ModelAndView mav = new ModelAndView("clientState");

        mav.addObject("books", removeAll(bookRepo.loadAll(), client));
        mav.addObject("client", client);

        return mav;
    }
}
