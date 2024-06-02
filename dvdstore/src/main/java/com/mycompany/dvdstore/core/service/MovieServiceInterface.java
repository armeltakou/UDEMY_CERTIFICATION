package com.mycompany.dvdstore.core.service;

import com.mycompany.dvdstore.core.entity.Movie;

import java.util.List;

public interface MovieServiceInterface {
    void registerMovie(Movie movie);
    void registerGoLiveMovie(Movie movie);
    List<Movie> getMovieList();
}
