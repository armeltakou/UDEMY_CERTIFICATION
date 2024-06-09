package com.mycompany.dvdstore.core.entity;

import jakarta.persistence.*;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_app_user;

    @Column(nullable = false, length = 50)
    private String username;

    public AppUser() {}

    public AppUser(long id_app_user, String username) {
        this.id_app_user = id_app_user;
        this.username = username;
    }

    public long getId_app_user() {return id_app_user;}

    public void setId_app_user(long id_app_user) {this.id_app_user = id_app_user;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}
}
