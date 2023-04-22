package com.awbd.proiect.controllers;


import com.awbd.proiect.domain.Genre;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping("")
    public ModelAndView getHome(){

        return new ModelAndView("main");
    }
}
