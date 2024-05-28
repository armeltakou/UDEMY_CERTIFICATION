package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MemoryMovieRepository implements MovieRepositoryInterface {

    private static List<Movie> movies = new ArrayList<>();

    @Autowired
    private MovieRepositoryInterface movieRepository;

    public MovieRepositoryInterface getMovieRepository() {
        return movieRepository;
    }

    public void setMovieRepository(MovieRepositoryInterface movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void addMovie(Movie movie){
        movies.add(movie);
        System.out.println("The movie "+movie.getTitre()+" and "+movie.getGenre()+" has been added.");
    }

}
