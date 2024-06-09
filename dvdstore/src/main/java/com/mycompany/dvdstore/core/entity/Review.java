package com.mycompany.dvdstore.core.entity;

import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_review;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_MOVIE", nullable = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_REVIEWER")
    private AppUser appUser;

    @Column(nullable = false)
    private Short mark;

    private String review_comment;

    public Review() {}

    public Review(long id_review, Movie movie, AppUser appUser, Short mark, String review_comment) {
        this.id_review = id_review;
        this.movie = movie;
        this.appUser = appUser;
        this.mark = mark;
        this.review_comment = review_comment;
    }

    public long getId_review() {return id_review;}

    public void setId_review(long id_review) {this.id_review = id_review;}

    public Movie getMovie() {return movie;}

    public void setMovie(Movie movie) {this.movie = movie;}

    public AppUser getAppUser() {return appUser;}

    public void setAppUser(AppUser appUser) {this.appUser = appUser;}

    public short getMark() {return mark;}

    public void setMark(Short mark) {this.mark = mark;}

    public String getReview_comment() {return review_comment;}

    public void setReview_comment(String review_comment) {this.review_comment = review_comment;}
}
