package com.dozortsev.bookstore.controller;

import com.dozortsev.bookstore.data.BookRepo;
import com.dozortsev.bookstore.data.ClientRepo;
import com.dozortsev.bookstore.model.Book;
import com.dozortsev.bookstore.model.Card;
import com.dozortsev.bookstore.model.Client;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

import static com.dozortsev.bookstore.util.Util.removeAll;
import static org.apache.log4j.Logger.getLogger;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@SessionAttributes({ "currClient", "allBooks" })
public class CardController {

    private final static Logger log = getLogger(CardController.class);

    @Autowired
    BookRepo bookRepo;
    @Autowired
    ClientRepo clientRepo;

    @RequestMapping(value = "/Welcome", method = GET)
    public ModelAndView clientBuyBook(@ModelAttribute("currClient") Client client,
                                      @ModelAttribute("allBooks") Set<Book> books,
                                      @RequestParam("idBook") Integer idBook,
                                      @RequestParam("status") Boolean status) {

        client.getCards().add(new Card(client, bookRepo.load(idBook), status));

        ModelAndView mav = new ModelAndView("clientState");
        mav.addObject("books", removeAll(books, client));
        mav.addObject("client", clientRepo.update(client));

        return mav;
    }
}
