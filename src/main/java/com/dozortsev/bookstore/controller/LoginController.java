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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import static com.dozortsev.bookstore.util.Util.removeAll;
import static org.apache.log4j.Logger.getLogger;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LoginController {

    private final static Logger log = getLogger(LoginController.class);

    @Autowired
    BookRepo bookRepo;
    @Autowired
    ClientRepo clientRepo;

    @RequestMapping(value = "/Client/Save", method = POST)
    public String clientSave(@ModelAttribute("newClient") Client client) {

        clientRepo.save(client);

        return "redirect:/SignIn";
    }

    @RequestMapping(value = "/Welcome", method = POST)
    public ModelAndView signIn(@RequestParam String email,
                               @RequestParam String pwd) {

        Client client = clientRepo.authentication(email, pwd);

        if (client == null)
            return new ModelAndView("redirect:/SignIn");

        ModelAndView mav = new ModelAndView("appState", "page", "bookstore");

        return mav.addObject(removeAll(bookRepo.loadAll(), client)).addObject(client);
    }
}
