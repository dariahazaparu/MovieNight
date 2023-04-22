package com.awbd.proiect.controllers;

import com.awbd.proiect.domain.Genre;
import com.awbd.proiect.services.GenreService;
import com.awbd.proiect.services.GenreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/genres")
public class GenreController {

    GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @RequestMapping("")
    //public String Genres() {
    public ModelAndView Genres(){
        //return "genre";

        ModelAndView modelAndView = new ModelAndView("genres");
        List<Genre> genres = genreService.findAll();
        modelAndView.addObject("genres",genres);
        return modelAndView;
    }

}
