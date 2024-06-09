package com.mycompany.dvdstore.core.service;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

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
        movieRepositoryInterface.save(movie);
        return movie;
    }

    public Movie registerGoLiveMovie(Movie movie){
        movieRepositoryInterface.save(movie);
        return movie;
    }

    @Override
    public Iterable<Movie> getMovieList() {
        Iterable<Movie> movies = movieRepositoryInterface.findAll();
        movies.forEach(movie -> {
            movie.getActor().getFirstName();
            movie.getActor().getLastName();
        });
        return movies;
    }

    @Override
    public Movie getMovieById(long id) {
        //return movieRepositoryInterface.findById(id).orElseThrow();
        Optional<Movie> optionalMovie = movieRepositoryInterface.findById(id);
        if (optionalMovie.isEmpty()){
            throw new NoSuchElementException();
        }
        Movie movie=optionalMovie.get();
        //Initialize proxys
        movie.getActor().getFirstName();
        movie.getReviews().forEach(review -> {
            review.getMark();
            review.setMovie(null);
        });
        //

        return movie;
    }
}
