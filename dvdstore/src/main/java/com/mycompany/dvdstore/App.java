package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieControllerInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.mycompany.dvdstore.controller", "com.mycompany.dvdstore.repository.file", "com.mycompany.dvdstore.service"})
@PropertySource("classpath:application.properties")
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

        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
        MovieControllerInterface movieController = applicationContext.getBean(MovieControllerInterface.class);
        movieController.addMovie();
    }

}
