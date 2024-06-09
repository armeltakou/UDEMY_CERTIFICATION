package com.mycompany.dvdstore.movie.service;

import com.mycompany.dvdstore.core.entity.movie.Movie;

public interface MovieServiceInterface {
    Movie registerMovie(Movie movie);
    Movie registerGoLiveMovie(Movie movie);
    Iterable<Movie> getMovieList();
    Movie getMovieById(long id);
}
