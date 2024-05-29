package com.mycompany.dvdstore.service;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
import org.springframework.stereotype.Service;

@Service
public class DefaultMovieService implements MovieServiceInterface {

    public DefaultMovieService(MovieRepositoryInterface movieRepositoryInterface) {
        this.movieRepositoryInterface = movieRepositoryInterface;
    }

    private final MovieRepositoryInterface movieRepositoryInterface;

    public MovieRepositoryInterface getMovieRepositoryInterface() {
        return movieRepositoryInterface;
    }

    /*public void setMovieRepositoryInterface(MovieRepositoryInterface movieRepositoryInterface) {
        this.movieRepositoryInterface = movieRepositoryInterface;
    }*/

    public void registerMovie(Movie movie){
        movieRepositoryInterface.addMovie(movie);
    }

    public void registerGoLiveMovie(Movie movie){
        movieRepositoryInterface.addMovie(movie);
    }

}
