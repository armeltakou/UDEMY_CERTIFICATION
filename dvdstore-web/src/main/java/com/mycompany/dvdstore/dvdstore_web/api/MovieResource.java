package com.mycompany.dvdstore.dvdstore_web.api;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieResource {

    @Autowired
    private MovieServiceInterface movieService;

    @GetMapping
    public Iterable<Movie> list(){ return movieService.getMovieList(); }

    @GetMapping("/{id_movie}")
    public Movie get(@PathVariable("id_movie") long id_movie){
        return movieService.getMovieById(id_movie);
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
