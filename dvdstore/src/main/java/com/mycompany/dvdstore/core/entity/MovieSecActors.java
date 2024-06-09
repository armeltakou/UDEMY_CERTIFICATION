package com.mycompany.dvdstore.core.entity;

import jakarta.persistence.*;

@Entity
public class MovieSecActors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_movie_sec_actors;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_MOVIE", nullable = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_ACTOR", nullable = false)
    private Actor actor;

    public MovieSecActors() {}

    public MovieSecActors(long id_movie_sec_actors, Movie movie, Actor actor) {
        this.id_movie_sec_actors = id_movie_sec_actors;
        this.movie = movie;
        this.actor = actor;
    }

    public long getId_movie_sec_actors() {return id_movie_sec_actors;}

    public void setId_movie_sec_actors(long id_movie_sec_actors) {
        this.id_movie_sec_actors = id_movie_sec_actors;
    }

    public Movie getMovie() {return movie;}

    public void setMovie(Movie movie) {this.movie = movie;}

    public Actor getActor() {return actor;}

    public void setActor(Actor actor) {this.actor = actor;}
}
