package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieServiceInterface;

import java.util.Scanner;

public class MovieController implements MovieControllerInterface {

    //private DefaultMovieService movieService = new DefaultMovieService();
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
