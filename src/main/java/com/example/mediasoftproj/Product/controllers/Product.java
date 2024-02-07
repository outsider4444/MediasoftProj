package com.example.mediasoftproj.Product.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Product {

    @RequestMapping(value="/")
    public ModelAndView messages() {
        String one = "one";
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("messages", "hello");
        return mav;
    }
}
