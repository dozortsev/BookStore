package com.dozortsev.bookstore.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Map;

import static java.lang.String.format;
import static org.apache.log4j.Logger.getLogger;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class LogoutController extends WebMvcConfigurerAdapter {

    private final static Logger log = getLogger(LogoutController.class);

    @RequestMapping(value = "/", method = GET)
    public ModelAndView logout(ModelAndView mav) {

        log.info("In logout controller.");

        Map<String, Object> model = mav.getModel();

        for (Map.Entry<String, Object> entry : model.entrySet()) {

            log.info(format("Key %s; Value %s", entry.getKey(), entry.getValue()));
        }
        return new ModelAndView("signin");
    }
}
