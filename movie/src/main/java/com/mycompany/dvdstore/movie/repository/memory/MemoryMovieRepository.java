package com.mycompany.dvdstore.movie.repository.memory;

import com.mycompany.dvdstore.core.entity.movie.Movie;
import com.mycompany.dvdstore.movie.repository.MovieRepositoryInterface;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {

    private static List<Movie> movies = new ArrayList<>();

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

    @Query("SELECT movie FROM Movie movie INNER JOIN FETCH movie.id_main_actor")
    @Override
    public Iterable<Movie> findAll() {throw new UnsupportedOperationException();}

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> longs) {throw new UnsupportedOperationException();}

    @Override
    public long count() {throw new UnsupportedOperationException();}

    @Override
    public void deleteById(Long aLong) {throw new UnsupportedOperationException();}

    public Optional<Movie> findById_movie(long id) {
        return movies.stream().
                filter(m -> m.getId_movie()==id).
                findFirst();
    }

    @Override
    public void delete(Movie entity) {throw new UnsupportedOperationException();}

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {throw new UnsupportedOperationException();}

    @Override
    public void deleteAll(Iterable<? extends Movie> entities) {throw new UnsupportedOperationException();}

    @Override
    public void deleteAll() {throw new UnsupportedOperationException();}
}
