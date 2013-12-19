package com.dozortsev.bookstore.controller;

import com.dozortsev.bookstore.data.BookRepo;
import com.dozortsev.bookstore.data.CardRepo;
import com.dozortsev.bookstore.data.ClientRepo;
import com.dozortsev.bookstore.model.Card;
import com.dozortsev.bookstore.model.Client;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import static com.dozortsev.bookstore.util.Util.removeAll;
import static org.apache.log4j.Logger.getLogger;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@SessionAttributes("client")
public class ClientController {

    @Autowired
    CardRepo cardRepo;
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    BookRepo bookRepo;

    private final static Logger log = getLogger(ClientController.class);

    @RequestMapping(value = "/toShowcase", method = GET)
    public ModelAndView backToShowcase(@ModelAttribute Client client) {

        ModelAndView mav = new ModelAndView("appState", "page", "bookstore");

        return mav.addObject(removeAll(bookRepo.loadAll(), client)).addObject(client);
    }

    @RequestMapping(value = "/Client/Book/{bookId}/Status/{status}", method = GET)
    public ModelAndView bookAction(@ModelAttribute Client client,
                                   @PathVariable Integer bookId,
                                   @PathVariable Boolean status) {

        ModelAndView mav = new ModelAndView("appState", "page", "bookstore");

        client.getCards().add(new Card(client, bookRepo.load(bookId), status));

        return mav.addObject(clientRepo.update(client))
                  .addObject(removeAll(bookRepo.loadAll(), client));
    }

    @RequestMapping(value = "/Client/Card/{cardId}/Status/{status}", method = GET)
    public ModelAndView cardAction(@PathVariable Integer cardId,
                                   @PathVariable Boolean status) {

        ModelAndView mav = new ModelAndView("appState", "page", "client");

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
        return mav.addObject(client);
    }

    @RequestMapping(value = "/Client/Update", method = POST)
    public ModelAndView clientEdit(@ModelAttribute("update") Client client) {

        ModelAndView mav = new ModelAndView("appState", "page", "client");

        Integer id = clientRepo.update(client).getId();

        return mav.addObject(clientRepo.load(id));
    }
}
