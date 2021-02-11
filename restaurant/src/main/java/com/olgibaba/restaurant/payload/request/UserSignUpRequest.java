package com.olgibaba.restaurant.payload.request;

import javax.validation.constraints.NotBlank;

public class UserSignUpRequest {

    @NotBlank
    private String mail;

    @NotBlank
    private String password;

    @NotBlank
    private String country;

    @NotBlank
    private String postcode;

    @NotBlank
    private String city;

    @NotBlank
    private String address;

    public UserSignUpRequest(@NotBlank String mail, @NotBlank String password, @NotBlank String country, @NotBlank String postcode, @NotBlank String city, @NotBlank String address) {
        this.mail = mail;
        this.password = password;
        this.country = country;
        this.postcode = postcode;
        this.city = city;
        this.address = address;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
