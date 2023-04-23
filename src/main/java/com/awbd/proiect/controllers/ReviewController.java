package com.awbd.proiect.controllers;

import com.awbd.proiect.domain.Actor;
import com.awbd.proiect.domain.Country;
import com.awbd.proiect.domain.Movie;
import com.awbd.proiect.domain.Review;
import com.awbd.proiect.exceptions.ResourceNotFoundException;
import com.awbd.proiect.services.MovieService;
import com.awbd.proiect.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    ReviewService reviewService;

    @Autowired
    MovieService movieService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @RequestMapping("")
    public String Reviews(){
        return "redirect:/movies";
    }

    @RequestMapping("/{id}")
    public ModelAndView getByMovieId(@PathVariable String id, Model model) {
        ModelAndView modelAndView = new ModelAndView("reviews");
        Movie movie = movieService.findById(Long.parseLong(id));
        modelAndView.addObject("reviews", movie.getReviews());
        modelAndView.addObject("movie", movie);
        return modelAndView;
    }

    @RequestMapping("/form/{id}")
    public String actorForm(@PathVariable String id, Model model) {
        Review review = new Review();
        Movie movie = movieService.findById(Long.parseLong(id));
        review.setMovie(movie);
        model.addAttribute("review", review);
        model.addAttribute("movie", review.getMovie());
        return "reviewForm";
    }

    @PostMapping("")
    public String saveOrUpdate(@ModelAttribute Review review) {
        Review savedReview;
        savedReview = reviewService.save(review);
        return "redirect:/reviews/"+review.getMovie().getId();
    }

    @RequestMapping("/delete/{id}")
    public String deleteById (@PathVariable String id) {
        long movieId = reviewService.findById(Long.parseLong(id)).getMovie().getId();
        reviewService.deleteById(Long.parseLong(id));
        return "redirect:/movies/"+movieId;
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
