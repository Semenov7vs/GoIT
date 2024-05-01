package org.example.module15.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController {

    @RequestMapping(value = "/test")
    public ModelAndView testMethod(){
        ModelAndView hw =new ModelAndView();
        hw.addObject("Hello");
        return hw;
    }
}
