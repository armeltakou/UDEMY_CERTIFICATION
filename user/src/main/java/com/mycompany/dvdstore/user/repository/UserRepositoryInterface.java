package com.mycompany.dvdstore.user.repository;

import com.mycompany.dvdstore.core.entity.user.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryInterface extends CrudRepository<AppUser,Long> {
    /*Movie addMovie(Movie movie);
    List<Movie> list();
    Movie getById(long id);*/
}
