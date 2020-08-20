package com.app.entities;

import javax.persistence.*;

@Entity
@Table(name = "more_user_info")
public class MoreUserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="more_user_info_id")
    private int moreUserInfoId;

    @Column(name="user_id")
    private int userId;

    @Column
    private String description;

    @Column
    private String university;

    @Column
    private String faculty;

    @Column
    private int year;

    @Column
    private String city;

    public MoreUserInfo() {
    }

    public int getMoreUserInfoId() {
        return moreUserInfoId;
    }

    public void setMoreUserInfoId(int moreUserInfoId) {
        this.moreUserInfoId = moreUserInfoId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
