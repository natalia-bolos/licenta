package com.app.entities;

import javax.persistence.*;

@Entity
@Table(name = "favourite_subject")
public class FavouriteSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="favourite_subject_id")
    private int favouriteSubjectId;

    @Column(name="favourite_subject_name")
    private String favouriteSubjectName;

    @Column(name="user_id")
    private int userId;

    public FavouriteSubject() {
    }

    public int getFavouriteSubjectId() {
        return favouriteSubjectId;
    }

    public void setFavouriteSubjectId(int favouriteSubjectId) {
        this.favouriteSubjectId = favouriteSubjectId;
    }

    public String getFavouriteSubjectName() {
        return favouriteSubjectName;
    }

    public void setFavouriteSubjectName(String favouriteSubjectName) {
        this.favouriteSubjectName = favouriteSubjectName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
