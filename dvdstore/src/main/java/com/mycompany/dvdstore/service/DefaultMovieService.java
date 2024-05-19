package com.mycompany.dvdstore.service;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;

public class DefaultMovieService implements MovieServiceInterface {

    private MovieRepositoryInterface movieRepositoryInterface;

    public MovieRepositoryInterface getMovieRepositoryInterface() {
        return movieRepositoryInterface;
    }

    public void setMovieRepositoryInterface(MovieRepositoryInterface movieRepositoryInterface) {
        this.movieRepositoryInterface = movieRepositoryInterface;
    }

    public void registerMovie(Movie movie){
        movieRepositoryInterface.addMovie(movie);
    }

    public void registerGoLiveMovie(Movie movie){
        movieRepositoryInterface.addMovie(movie);
    }

}
