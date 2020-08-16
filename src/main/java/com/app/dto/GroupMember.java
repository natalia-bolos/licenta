package com.app.dto;

import com.app.entities.Role;


public class GroupMember {
    private int userId;


    private String name;


    private String mail;


    private String username;

    private Role role;

    public GroupMember(int userId, String name, String mail, String username, Role role) {
        this.userId = userId;
        this.name = name;
        this.mail = mail;
        this.username = username;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
