package com.mycompany.dvdstore.actor.api;

import com.mycompany.dvdstore.actor.repository.ActorRepositoryInterface;
import com.mycompany.dvdstore.core.entity.actor.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/actor")
public class ActorResource {

    @Autowired
    private ActorRepositoryInterface actorRepository;

    @GetMapping("/{id_actor}")
    public Actor get(@PathVariable("id_actor") long id_actor){
        return actorRepository.findById(id_actor).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public ActorRepositoryInterface getActorRepository() {return actorRepository;}

    public void setActorRepository(ActorRepositoryInterface actorRepository) {this.actorRepository = actorRepository;}
}
