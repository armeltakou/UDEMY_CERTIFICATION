package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieControllerInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args){
        System.out.println("Bienvenue dans ma galerie de film");

        /*
        MovieController movieController = new MovieController();

        DefaultMovieService movieService = new DefaultMovieService();
        movieController.setMovieService(movieService);
        FileMovieRepository movieRepository = new FileMovieRepository();
        movieService.setMovieRepositoryInterface(movieRepository);
        */

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MovieControllerInterface movieController = applicationContext.getBean(MovieControllerInterface.class);
        movieController.addMovie();
    }

}
