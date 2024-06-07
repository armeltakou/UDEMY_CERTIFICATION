package com.mycompany.dvdstore.dvdstore_web.api;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import com.mycompany.dvdstore.dvdstore_web.form.MovieForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieResource {

    @Autowired
    private MovieServiceInterface movieService;

    @GetMapping
    public List<Movie> list(){ return movieService.getMovieList(); }

    @GetMapping("/{id}")
    public Movie get(@PathVariable("id") long id){
        return movieService.getMovieById(id);
    }

    /*
    @GetMapping("/add-movie-form")
    public String displayMovieForm(@ModelAttribute MovieForm movie){
        return "add-movie-form";
    }
    */

    @PostMapping
    public Movie add(@RequestBody Movie movie){ return movieService.registerMovie(movie); }
}
