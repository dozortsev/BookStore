package com.dozortsev.bookstore.controller;

import com.dozortsev.bookstore.data.BookRepo;
import com.dozortsev.bookstore.data.CardRepo;
import com.dozortsev.bookstore.data.ClientRepo;
import com.dozortsev.bookstore.model.Card;
import com.dozortsev.bookstore.model.Client;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static com.dozortsev.bookstore.util.Util.removeAll;
import static java.lang.String.format;
import static org.apache.log4j.Logger.getLogger;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@SessionAttributes("currClient")
public class ClientController {

    @Autowired
    CardRepo cardRepo;
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    BookRepo bookRepo;

    private final static Logger log = getLogger(ClientController.class);

    @RequestMapping(value = "/toShowcase", method = GET)
    public String backToShowcase(Model model,
                                 @ModelAttribute("currClient") Client client) {

        model.addAttribute("allBooks", removeAll(bookRepo.loadAll(), client));

        return "redirect:/Showcase";
    }

    @RequestMapping(value = "/Client/Card/{cardId}", method = GET)
    public ModelAndView cardAction(@PathVariable Integer cardId,
                                   @RequestParam Boolean status) {

        Card card = cardRepo.load(cardId);
        Client client = card.getClient();

        if (status) {
            card.setStatus(true);
            cardRepo.update(card);
            client = card.getClient();
        } else {
            client.getCards().remove(card);
            cardRepo.delete(card);
        }
        return new ModelAndView("redirect:/Client", "currClient", client);
    }

    @RequestMapping(value = "/Client/Update", method = POST)
    public String clientEdit(Model model,
                             @ModelAttribute("updClient") Client client) {

        Integer id = clientRepo.update(client).getId();
        model.addAttribute("currClient", clientRepo.load(id));

        return "redirect:/Client";
    }
}
