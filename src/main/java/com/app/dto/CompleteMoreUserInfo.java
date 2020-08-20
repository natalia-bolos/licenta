package com.app.dto;

import com.app.entities.FavouriteSubject;
import com.app.entities.MoreUserInfo;
import com.app.entities.Skill;

import java.util.List;

public class CompleteMoreUserInfo {

    private MoreUserInfo moreUserInfo;
    private List<Skill> skills;
    private List<FavouriteSubject> subjects;
    private String name;
    private String mail;

    public CompleteMoreUserInfo() {
    }

    public CompleteMoreUserInfo(MoreUserInfo moreUserInfo, List<Skill> skills, List<FavouriteSubject> subjects) {
        this.moreUserInfo = moreUserInfo;
        this.skills = skills;
        this.subjects = subjects;
    }

    public CompleteMoreUserInfo(MoreUserInfo moreUserInfo, List<Skill> skills, List<FavouriteSubject> subjects, String name, String mail) {
        this.moreUserInfo = moreUserInfo;
        this.skills = skills;
        this.subjects = subjects;
        this.name = name;
        this.mail = mail;
    }

    public MoreUserInfo getMoreUserInfo() {
        return moreUserInfo;
    }

    public void setMoreUserInfo(MoreUserInfo moreUserInfo) {
        this.moreUserInfo = moreUserInfo;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<FavouriteSubject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<FavouriteSubject> subjects) {
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
