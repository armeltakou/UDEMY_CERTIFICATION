package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieControllerInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {

    public static void main(String[] args){
        System.out.println("Bienvenue dans ma galerie de film");
        ApplicationContext applicationContext = SpringApplication.run(App.class, args);
        MovieControllerInterface movieController = applicationContext.getBean(MovieControllerInterface.class);
        movieController.addMovie();
    }

}
