package dozortsev.bookstore.controller;

import dozortsev.bookstore.data.ClientRepo;
import dozortsev.bookstore.model.Client;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ClientController {

        @Autowired
        private ClientRepo clientRepo;

        @RequestMapping(value = "/Client", method = GET)
        public String client(Model model,
                             @ModelAttribute Client client, BindingResult result) {

                //model.addAttribute("client", client);

                return "index";
        }

        @RequestMapping(value = "/SignIn", method = POST)
        public ModelAndView signIn(ModelAndView model,
                             @RequestParam("email") String email,
                             @RequestParam("pwd")   String pwd) {

                Client client = clientRepo.authentication(email, pwd);

                if (client == null)
                        return new ModelAndView("redirect:/SignUp");

                model.addObject("client", client);
                model.setViewName("index");

                return model;
        }

        @RequestMapping(value = "/SignUp", method = POST)
        public String signUp(Model model,
                             @RequestParam("name")    String name,
                             @RequestParam("surname") String surname,
                             @RequestParam("email")   String email,
                             @RequestParam("pwd")     String pwd) {
                
                Client client = new Client(name, surname, pwd, email);

                clientRepo.save(client);

                model.addAttribute("client", client);

                return "redirect:/Client";
        }


}
