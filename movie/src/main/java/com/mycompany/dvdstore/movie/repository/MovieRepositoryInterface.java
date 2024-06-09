package com.mycompany.dvdstore.movie.repository;

import com.mycompany.dvdstore.core.entity.movie.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepositoryInterface extends CrudRepository<Movie,Long> { }
