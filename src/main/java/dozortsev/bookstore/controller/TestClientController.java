package dozortsev.bookstore.controller;

import dozortsev.bookstore.data.ClientRepo;
import dozortsev.bookstore.model.Client;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class TestClientController {

        private final static Logger log = Logger.getLogger(TestClientController.class);

        @Autowired ClientRepo clientRepo;

        @RequestMapping(value = "/Client")
        public ModelAndView client() {
                return new ModelAndView("client", "client", new Client());
        }

        @RequestMapping(value = "/AddClient", method = POST)
        public ModelAndView clientSave(Client client, BindingResult result) {

                ModelAndView mav = new ModelAndView();

                if (result.hasErrors()) {
                        mav.setViewName("client");
                        return mav;
                }

                clientRepo.save(client);
                mav.setViewName("index");
                mav.addObject("clients", clientRepo.loadAll());

                return mav;
        }
}
