package com.mycompany.dvdstore.core.repository.memory;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Repository
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

    @Override
    public Movie save(Movie movie){
        movies.add(movie);
        System.out.println("The movie "+movie.getTitre()+" and "+movie.getGenre()+" has been added.");
        return movie;
    }

    @Override
    public <S extends Movie> Iterable<S> saveAll(Iterable<S> entities) {throw new UnsupportedOperationException();}

    @Override
    public Optional<Movie> findById(Long aLong) {return Optional.empty();}

    @Override
    public boolean existsById(Long aLong) {throw new UnsupportedOperationException();}

    @Override
    public Iterable<Movie> findAll() {throw new UnsupportedOperationException();}

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> longs) {throw new UnsupportedOperationException();}

    @Override
    public long count() {throw new UnsupportedOperationException();}

    @Override
    public void deleteById(Long aLong) {throw new UnsupportedOperationException();}

    @Override
    public Optional<Movie> findById(long id) {
        return movies.stream().
                filter(m -> m.getId_movie()==id).
                findFirst();
    }

    @Override
    public void delete(Movie entity) {throw new UnsupportedOperationException();}

    @Override
    public void deleteAll(Iterable<? extends Movie> entities) {throw new UnsupportedOperationException();}

    @Override
    public void deleteAll() {throw new UnsupportedOperationException();}
}
