package com.mycompany.dvdstore.dvdstore_web.controller;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import com.mycompany.dvdstore.dvdstore_web.form.MovieForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/movie")
public class HomeController {

    @Autowired
    private MovieServiceInterface movieService;

    @GetMapping("/home")
    public ModelAndView displayHome(){
        ModelAndView mv = new ModelAndView("movie-home");
        mv.addObject("movies", movieService.getMovieList());
        return mv;
    }

    /*
    @GetMapping("/{id}")
    public ModelAndView displayMovieCard(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("movie-details");
        mv.addObject("movie", movieService.getMovieById(id));
        return mv;
    }
    */

    @GetMapping("/add-movie-form")
    public String displayMovieForm(@ModelAttribute MovieForm movie){
        return "add-movie-form";
    }

    @PostMapping("/add")
    public String addMovie(@Valid @ModelAttribute MovieForm movieForm, BindingResult results){
        if(results.hasErrors())
            return "add-movie-form";
        Movie movie = new Movie();
        movie.setId(movieForm.getId());
        movie.setTitre(movieForm.getTitre());
        movie.setGenre(movieForm.getGenre());
        movie.setDescription(movieForm.getDescription());
        movieService.registerMovie(movie);
        return "movie-added";
    }
}
