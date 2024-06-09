package com.mycompany.dvdstore.actor.repository;

import com.mycompany.dvdstore.core.entity.actor.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepositoryInterface extends CrudRepository<Actor,Long> {
    /*Movie addMovie(Movie movie);
    List<Movie> list();
    Movie getById(long id);*/
}
