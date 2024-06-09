package com.mycompany.dvdstore.user.api;

import com.mycompany.dvdstore.core.entity.user.AppUser;
import com.mycompany.dvdstore.user.repository.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
public class UserResource {

    @Autowired
    private UserRepositoryInterface userRepository;

    @GetMapping("/{id_app_user}")
    public AppUser get(@PathVariable("id_app_user") long id_app_user){
        return userRepository.findById(id_app_user).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public UserRepositoryInterface getUserRepository() {return userRepository;}

    public void setUserRepository(UserRepositoryInterface userRepository) {this.userRepository = userRepository;}
}
