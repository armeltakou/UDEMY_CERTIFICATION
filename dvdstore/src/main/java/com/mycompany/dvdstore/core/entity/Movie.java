package com.mycompany.dvdstore.core.entity;

public class Movie {

    private long id;
    private String titre;
    private String genre;
    private String description;

    public Movie() {}

    public Movie(long id, String titre, String genre, String description){
        this.id=id;
        this.titre=titre;
        this.genre=genre;
        this.description=description;
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

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
}
