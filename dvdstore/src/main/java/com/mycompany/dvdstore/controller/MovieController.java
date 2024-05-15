package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieService;

import java.util.Scanner;

public class MovieController {

    MovieService movieService = new MovieService();

    public void addUsingConsole(){
        System.out.println("Add using Console Application");
        System.out.println("Veuillez entrer le Titre du film : ");
        Scanner scan = new Scanner(System.in);
        String titre = scan.nextLine();
        System.out.println("Veuillez entrer le Genre du film : ");
        String genre = scan.nextLine();
        Movie movie = new Movie(titre, genre);
        //MovieService movieService = new MovieService();
        //movieService.registerMovie(movie);
        movieService.registerGoLiveMovie(movie);
    }

}
