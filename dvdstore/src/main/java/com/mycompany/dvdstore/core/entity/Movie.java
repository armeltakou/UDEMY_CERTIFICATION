package com.mycompany.dvdstore.core.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_movie;

    @Column(nullable = false, length = 20)
    private String titre;

    @Column(nullable = false, length = 20)
    private String genre;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_MAIN_ACTOR")
    private Actor actor;

    @ManyToMany
    @JoinTable(
            name="MOVIE_SEC_ACTORS",
            joinColumns = {@JoinColumn(name="ID_MOVIE")},
            inverseJoinColumns = {@JoinColumn(name="ID_ACTOR")}
    )
    private List<Actor> secondaryActors=new ArrayList<>();

    @OneToMany(
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "movie"
    )
    private List<Review> reviews=new ArrayList<>();

    public Movie() {}

    public Movie(long id_movie, String titre, String genre) {
        this.id_movie = id_movie;
        this.titre = titre;
        this.genre = genre;
    }

    public Movie(long id_movie, String titre, String genre, Actor actor) {
        this.id_movie = id_movie;
        this.titre = titre;
        this.genre = genre;
        this.actor = actor;
    }

    public Movie(long id_movie, String titre, String genre, String description, Actor actor) {
        this.id_movie = id_movie;
        this.titre = titre;
        this.genre = genre;
        this.description = description;
        this.actor = actor;
    }

    public long getId_movie() {return id_movie;}

    public void setId_movie(long id_movie) {this.id_movie = id_movie;}

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public Actor getActor() {return actor;}

    public void setActor(Actor actor) {this.actor = actor;}

    public List<Actor> getSecondaryActors() {return secondaryActors;}

    public void setSecondaryActors(List<Actor> secondaryActors) {this.secondaryActors = secondaryActors;}

    public List<Review> getReviews() {return reviews;}

    public void setReviews(List<Review> reviews) {this.reviews = reviews;}
}
