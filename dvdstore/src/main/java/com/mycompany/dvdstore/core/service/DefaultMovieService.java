package com.mycompany.dvdstore.core.service;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Movie> getMovieList() {
        return movieRepositoryInterface.list();
    }
}
