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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static com.dozortsev.bookstore.util.Util.isClientValid;
import static com.dozortsev.bookstore.util.Util.removeAll;
import static java.lang.String.format;
import static org.apache.log4j.Logger.getLogger;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ClientController {

    private final static Logger log = getLogger(ClientController.class);

    @Autowired
    CardRepo cardRepo;
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
            return new ModelAndView("signin");

        log.info("Client not null.");

        if (isClientValid(client)) {

            log.info("Client valid.");
            clientRepo.save(client);
        }
        ModelAndView mav = new ModelAndView("bookstore");

        mav.addObject("books", removeAll(bookRepo.loadAll(), client));
        mav.addObject("client", client);

        return mav;
    }

    @RequestMapping(value = "/Welcome", method = GET)
    public ModelAndView clientBuyBook(@RequestParam("idBook") Integer idBook,
                                      @RequestParam("idClient") Integer idClient,
                                      @RequestParam("status") Boolean status) {

        Client client = clientRepo.load(idClient);

        client.getCards().add(new Card(client, bookRepo.load(idBook), status));

        ModelAndView mav = new ModelAndView("bookstore");
        mav.addObject("books", removeAll(bookRepo.loadAll(), client));
        mav.addObject("client", clientRepo.update(client));

        return mav;
    }

    @RequestMapping(value = "/Client/{id}", method = GET)
    public ModelAndView client(@PathVariable Integer id) {

        return new ModelAndView("client", "client", clientRepo.load(id));
    }

    @RequestMapping(value = "/Client/Update", method = POST)
    public ModelAndView clientEdit(@ModelAttribute("clientEdit") Client client) {

        clientRepo.update(client);
        ModelAndView mav = new ModelAndView("redirect:/Client/{id}");
        mav.addObject("id", client.getId());

        return mav;
    }

    @RequestMapping(value = "/Client/{clientId}/Card/{cardId}", method = GET)
    public ModelAndView card(@PathVariable Integer clientId,
                             @PathVariable Integer cardId,
                             @RequestParam Boolean status) {

        Card card = cardRepo.load(cardId);

        if (status) {
            card.setStatus(true);
            cardRepo.update(card);
        } else {
            cardRepo.delete(card);
        }
        return new ModelAndView("client", "client", clientRepo.load(clientId));
    }

    @RequestMapping(value = "/Client/Edit/{id}", method = GET)
    public ModelAndView editClient(@PathVariable Integer id) {

        return new ModelAndView("clientEdit", "client", clientRepo.load(id));
    }
}
