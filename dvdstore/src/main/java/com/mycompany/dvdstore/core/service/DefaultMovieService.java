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

    public Movie registerMovie(Movie movie){
        movieRepositoryInterface.addMovie(movie);
        return movie;
    }

    public Movie registerGoLiveMovie(Movie movie){
        movieRepositoryInterface.addMovie(movie);
        return movie;
    }

    @Override
    public List<Movie> getMovieList() {
        return movieRepositoryInterface.list();
    }

    @Override
    public Movie getMovieById(long id) {return movieRepositoryInterface.getById(id);}
}
