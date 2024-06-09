package com.mycompany.dvdstore.core.repository;

import com.mycompany.dvdstore.core.entity.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepositoryInterface extends CrudRepository<Actor,Long> {
    /*Movie addMovie(Movie movie);
    List<Movie> list();
    Movie getById(long id);*/
}
