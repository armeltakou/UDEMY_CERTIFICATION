package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieController;

public class App {

    public static void main(String[] args){
        System.out.println("Bienvenue dans ma galerie de film");
        MovieController movieController = new MovieController();
        movieController.addUsingConsole();
    }

}
