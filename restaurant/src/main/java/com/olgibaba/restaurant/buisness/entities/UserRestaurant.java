package com.olgibaba.restaurant.buisness.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name="restaurant")
public class UserRestaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "mail", unique = true)
    @Length(max = 90)
    private String mail;

    @Column(name = "password")
    @Length(max = 45)
    private String password;

    @Column(name = "country")
    @Length(max = 45)
    private String country;

    @Column(name = "postcode")
    @Pattern(regexp = "^([0-9]{5})$")
    private String postcode;

    @Column(name = "city")
    @Length(max = 45)
    private String city;

    @Column(name = "address")
    @Length(max = 200)
    private String address;

    @OneToMany(mappedBy = "restaurant")
    @JsonManagedReference
    private List<Orders> ordersList = new ArrayList<>();

    public UserRestaurant(String mail, String password, String country, String postcode, String city, String address) {
    }
}
