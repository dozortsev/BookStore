package dozortsev.bookstore.controller;

import dozortsev.bookstore.data.BookRepo;
import dozortsev.bookstore.data.ClientRepo;
import dozortsev.bookstore.model.Book;
import dozortsev.bookstore.model.Client;
import dozortsev.bookstore.model.ClientBook;

import org.apache.log4j.Logger;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

import static org.apache.log4j.Logger.getLogger;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ClientController {

        // todo Client may have 'add' add 'buy' books.

        // todo: Add logging in controllers

        // todo: Write simple test controller for using @ResponseBody annotation

        @Autowired BookRepo bookRepo;

        @Autowired ClientRepo clientRepo;

        private final static Logger log = getLogger(ClientController.class);

        @RequestMapping(value = "/Welcome", method = POST)
        public String signUp(Model view, @ModelAttribute Client client) {

                Set<Book> books = bookRepo.loadAll();

                for (ClientBook cb : client.getBooks())
                        books.remove(cb.getBook());

                view.addAttribute("client", client);
                view.addAttribute("books", books);

                return "bookstore";
        }

        @ModelAttribute public Client getClient(
                @RequestParam(value = "pwd", required = false)     String pwd,
                @RequestParam(value = "email", required = false)   String email,
                @RequestParam(value = "name", required = false)    String name,
                @RequestParam(value = "surname", required = false) String surname) {

                Client client;

                if (name != null && surname != null) {

                        client = new Client(name, surname, pwd, email);
                        clientRepo.save(client);
                } else {
                        client = clientRepo.authentication(email, pwd);
                }
                return client;
        }
}
