package com.mycompany.dvdstore.movie.api;

import com.mycompany.dvdstore.core.entity.actor.Actor;
import com.mycompany.dvdstore.core.entity.movie.Movie;
import com.mycompany.dvdstore.movie.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieResource {

    @Autowired
    private MovieServiceInterface movieService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping
    public ParallelFlux<Movie> list(){

        List<Mono<Movie>> movieMonos = new ArrayList<>();

        final WebClient webClient = webClientBuilder.baseUrl("http://actor-service").build();

        Iterable<Movie> movies = movieService.getMovieList();

        movies.forEach(movie ->
            movieMonos.add(webClient.get()
                    .uri("/actor/"+movie.getId_main_actor())
                    .retrieve()
                    .bodyToMono(Actor.class)
                    .map(actor -> {
                        movie.setActor(actor);
                        return movie;
                    }))
            //movie.setActor(restTemplate.getForObject("http://actor-service/actor/"+movie.getId_main_actor(), Actor.class));
        );

        final Flux<Movie> movieFlux =  Flux.concat(movieMonos);

        return movieFlux.parallel().runOn(Schedulers.boundedElastic());
    }

    @GetMapping("/{id_movie}")
    public Movie get(@PathVariable("id_movie") long id_movie){

        final WebClient webClient = webClientBuilder.baseUrl("http://actor-service").build();

        Movie movie = movieService.getMovieById(id_movie);

        final Actor actor = webClient.get().uri("/actor/"+movie.getId_main_actor())
                .retrieve()
                .bodyToMono(Actor.class)
                .block();

        movie.setActor(actor);

        return movie;
    }

    public MovieServiceInterface getMovieService() {return movieService;}

    public void setMovieService(MovieServiceInterface movieService) {this.movieService = movieService;}

    public WebClient.Builder getWebClientBuilder() {return webClientBuilder;}

    public void setWebClientBuilder(WebClient.Builder webClientBuilder) {this.webClientBuilder = webClientBuilder;}
}
