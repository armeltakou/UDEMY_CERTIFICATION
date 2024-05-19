package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieController;
import com.mycompany.dvdstore.repository.FileMovieRepository;
import com.mycompany.dvdstore.service.DefaultMovieService;

public class App {

    public static void main(String[] args){
        System.out.println("Bienvenue dans ma galerie de film");
        MovieController movieController = new MovieController();

        DefaultMovieService movieService = new DefaultMovieService();
        movieController.setMovieService(movieService);
        FileMovieRepository movieRepository = new FileMovieRepository();
        movieService.setMovieRepositoryInterface(movieRepository);

        movieController.addMovie();
    }

}
