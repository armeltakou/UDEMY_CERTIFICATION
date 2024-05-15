package com.mycompany.dvdstore.entity;

public class Movie {

    public String titre;
    public String genre;

    public Movie(String titre, String genre){
        this.titre=titre;
        this.genre=genre;
    }

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
}
