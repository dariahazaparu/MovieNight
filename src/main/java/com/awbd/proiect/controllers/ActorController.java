package com.awbd.proiect.controllers;

import com.awbd.proiect.domain.Actor;
import com.awbd.proiect.domain.Country;
import com.awbd.proiect.exceptions.ResourceNotFoundException;
import com.awbd.proiect.services.ActorService;
import com.awbd.proiect.services.CountryService;
import com.awbd.proiect.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/actors")
public class ActorController {

    ActorService actorService;

    @Autowired
    MovieService movieService;

    @Autowired
    CountryService countryService;

    @Autowired
    public ActorController (ActorService actorService) {
        this.actorService = actorService;
    }

    @RequestMapping("")
    public ModelAndView Actors() {
        ModelAndView modelAndView = new ModelAndView("actors");
        List<Actor> actors = actorService.findAll();
        modelAndView.addObject("actors", actors);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable String id, Model model) {
        Actor actor = actorService.findById(Long.valueOf((id)));
        model.addAttribute("actor", actor);
        return "actorDetails";
    }

    @RequestMapping("/form")
    public String actorForm(Model model) {
        model.addAttribute("actor", new Actor());
        List<Country> countriesAll = countryService.findAll();
        model.addAttribute("countriesAll", countriesAll);
        return "actorForm";
    }

    @PostMapping("")
    public String saveOrUpdate(@ModelAttribute Actor actor) {
        Actor savedActor;
        savedActor = actorService.save(actor);
        return "redirect:/actors";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("actor", actorService.findById(Long.parseLong(id)));
        List<Country> countriesAll = countryService.findAll();
        model.addAttribute("countriesAll", countriesAll);
        return "actorForm";
    }

    @RequestMapping("/delete/{id}")
    public String deleteById (@PathVariable String id) {
        actorService.deleteById(Long.parseLong(id));
        return "redirect:/actors";
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView handlerNotFoundException(Exception exception){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModel().put("exception",exception);
        modelAndView.setViewName("notFoundException");
        return modelAndView;
    }
}
