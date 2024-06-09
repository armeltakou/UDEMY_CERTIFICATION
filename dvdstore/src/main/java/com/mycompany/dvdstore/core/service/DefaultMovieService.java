package com.mycompany.dvdstore.core.service;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.ActorRepositoryInterface;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DefaultMovieService implements MovieServiceInterface {

    @Autowired
    private final MovieRepositoryInterface movieRepositoryInterface;

    @Autowired
    private final ActorRepositoryInterface actorRepositoryInterface;

    public DefaultMovieService(MovieRepositoryInterface movieRepositoryInterface, ActorRepositoryInterface actorRepositoryInterface) {
        this.movieRepositoryInterface = movieRepositoryInterface;
        this.actorRepositoryInterface = actorRepositoryInterface;
    }

    public MovieRepositoryInterface getMovieRepositoryInterface() {
        return movieRepositoryInterface;
    }

    public Movie registerMovie(Movie movie){
        movieRepositoryInterface.save(movie);
        return movie;
    }

    @Transactional
    public Movie registerGoLiveMovie(Movie movie){
        actorRepositoryInterface.save(movie.getActor());
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
        return movieRepositoryInterface.findAll();
    }

    @Override
    public Movie getMovieById(long id) {
        Optional<Movie> optionalMovie=movieRepositoryInterface.findById(id);
        if (optionalMovie.isEmpty()){
            throw new NoSuchElementException();
        }
        Movie movie=optionalMovie.get();

        movie.getReviews().forEach(review ->
                review.setMovie(null)
        );

        return movie;
    }
}
