package com.mycompany.dvdstore.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {

    /*@Autowired
    private MovieServiceInterface movieService;

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    @PostMapping("")
    public String addMovie(){return "movie-added";}*/

    @GetMapping("/home")
    public String displayHome(){return "movie_home";}

    /*
    @GetMapping("/home")
    public ModelAndView displayHome(){
        ModelAndView mv = new ModelAndView("movie-home");
        mv.addObject("movies", movieService.getMovieList());
        return mv;
    }
    @GetMapping("/{id_movie}")
    public ModelAndView displayMovieCard(@PathVariable("id_movie") long id_movie){
        ModelAndView mv = new ModelAndView("movie-details");
        mv.addObject("movie", movieService.getMovieById(id_movie));
        return mv;
    }

    @PostMapping("/add")
    public String addMovie(@Valid @ModelAttribute MovieForm movieForm, BindingResult results){
        if(results.hasErrors())
            return "add-movie-form";
        Movie movie = new Movie();
        Actor actor = new Actor(movieForm.getFirstName(), movieForm.getLastName());

        movie.setActor(actor);
        movie.setId_movie(movieForm.getId());
        movie.setTitre(movieForm.getTitre());
        movie.setGenre(movieForm.getGenre());
        movie.setDescription(movieForm.getDescription());

        movieService.registerMovie(movie);
        return "movie-added";
    }
    */

}
