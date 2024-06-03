package com.mycompany.dvdstore.dvdstore_web.controller;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/movie")
public class HomeController {

    @Autowired
    private MovieServiceInterface movieService;

    @RequestMapping("/home")
    public ModelAndView displayHome(){
        ModelAndView mv = new ModelAndView("movie-home");
        mv.addObject("movies", movieService.getMovieList());
        return mv;
    }

    @RequestMapping("/{id}")
    public ModelAndView displayMovieCard(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("movie-details");
        mv.addObject("movie", movieService.getMovieById(id));
        return mv;
    }
}
