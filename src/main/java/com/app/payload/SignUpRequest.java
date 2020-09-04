package com.app.payload;

import javax.validation.constraints.*;

public class SignUpRequest {
    @NotBlank
//    @Size(min = 4, max = 40)
    private String name;

    @NotBlank
//    @Size(min = 3, max = 15)
    private String username;

    @NotBlank
//    @Size(max = 40)
//    @Email
    private String mail;

    @NotBlank
//    @Size(min = 6, max = 20)
    private String password;

//    @NotBlank
//    @Size(min = 6, max = 20)
    private String  phoneNumber;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
