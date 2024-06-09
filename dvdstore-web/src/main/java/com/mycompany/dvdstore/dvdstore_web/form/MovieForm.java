package com.mycompany.dvdstore.dvdstore_web.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MovieForm {

    private long id;

    @NotBlank(message = "Veuillez entrer un titre")
    @Size(max=20, message = "Entrez un titre de 20 caractères au plus")
    private String titre;

    @NotBlank(message = "Veuillez choisir un genre")
    private String genre;

    @Size(max=255, message = "Entrez une description de 255 caractères au plus")
    private String description;

    @NotBlank(message = "Veuillez entrer un nom d'acteur")
    @Size(max=20, message = "Entrez un nom de 20 caractères au plus")
    private String firstName;

    @NotBlank(message = "Veuillez entrer un nom d'acteur")
    @Size(max=20, message = "Entrez un prenom de 20 caractères au plus")
    private String lastName;

    public MovieForm() {}

    public MovieForm(long id, String titre, String genre, String description, String firstName, String lastName) {
        this.id = id;
        this.titre = titre;
        this.genre = genre;
        this.description = description;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getTitre() {return titre;}

    public void setTitre(String titre) {this.titre = titre;}

    public String getGenre() {return genre;}

    public void setGenre(String genre) {this.genre = genre;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}
}