package com.olgibaba.restaurant.payload.request;


import javax.validation.constraints.NotBlank;

public class AdminLoginRequest {

    @NotBlank
    private String mail;

    @NotBlank
    private String password;

    public AdminLoginRequest(String mail, String password) {
        this.mail = mail;
        this.password = password;
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
}
