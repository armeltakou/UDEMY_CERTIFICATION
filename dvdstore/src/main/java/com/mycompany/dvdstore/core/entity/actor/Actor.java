package com.mycompany.dvdstore.core.entity.actor;

import jakarta.persistence.*;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_actor;

    @Column(nullable = false, length = 20)
    private String first_Name;

    @Column(length = 20)
    private String last_Name;

    public Actor() {}

    public Actor(String first_Name, String last_Name) {
        this.first_Name = first_Name;
        this.last_Name = last_Name;
    }

    public Actor(long id_actor, String first_Name, String last_Name) {
        this.id_actor = id_actor;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
    }

    public long getId_actor() {return id_actor;}

    public void setId_actor(long id_actor) {this.id_actor = id_actor;}

    public String getFirst_Name() {return first_Name;}

    public void setFirst_Name(String first_Name) {this.first_Name = first_Name;}

    public String getLast_Name() {return last_Name;}

    public void setLast_Name(String last_Name) {this.last_Name = last_Name;}
}
