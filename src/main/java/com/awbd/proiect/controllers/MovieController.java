package com.awbd.proiect.controllers;

import com.awbd.proiect.domain.Actor;
import com.awbd.proiect.domain.Genre;
import com.awbd.proiect.domain.Movie;
import com.awbd.proiect.services.ActorService;
import com.awbd.proiect.services.GenreService;
import com.awbd.proiect.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    MovieService movieService;

    @Autowired
    ActorService actorService;

    @Autowired
    GenreService genreService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("")
    public ModelAndView Movies() {
        ModelAndView modelAndView = new ModelAndView("movies");
        List<Movie> movies = movieService.findAll();
        modelAndView.addObject("movies", movies);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable String id, Model model){

        Movie movie = movieService.findById(Long.valueOf(id));
        model.addAttribute("movie",
                movie);
        return "movieDetails";
    }

    @RequestMapping("/form")
    public String movieForm(Model model) {
        model.addAttribute("movie", new Movie());
        List<Actor> actorsAll = actorService.findAll();
        model.addAttribute("actorsAll", actorsAll );
        List<Genre> genresAll = genreService.findAll();
        model.addAttribute("genresAll", genresAll);
        return "movieForm";
    }
}
