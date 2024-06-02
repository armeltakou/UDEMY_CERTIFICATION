package com.mycompany.dvdstore.dvdstore_web.controller;

import com.mycompany.dvdstore.core.controller.MovieControllerInterface;
import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class MovieController implements MovieControllerInterface {

    @Autowired
    private MovieServiceInterface movieService;

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    public void addMovie(){
        System.out.println("Veuillez entrer le Titre du film : ");
        Scanner scan = new Scanner(System.in);
        String titre = scan.nextLine();
        System.out.println("Veuillez entrer le Genre du film : ");
        String genre = scan.nextLine();
        Movie movie = new Movie(titre, genre);
        //DefaultMovieService movieService = new DefaultMovieService();
        //movieService.registerMovie(movie);
        movieService.registerGoLiveMovie(movie);
    }

}
