package com.mycompany.dvdstore.dvdstore_web.controller;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private MovieServiceInterface movieService;

    @RequestMapping("/dvdstore-home")
    public @ModelAttribute("movies") List<Movie> displayHome (){
        List<Movie> movies = movieService.getMovieList();
        return movies;
    }
}