package com.olgibaba.supplier.buisness.entities;
import lombok.*;

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
    private String mail;

    @Column(name = "password")
    private String password;

    @Column(name = "country")
    private String country;

    @Column(name = "postcode")
    @Pattern(regexp = "^([0-9]{5})$")
    private String postcode;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "restaurant")
    private List<Orders> ordersList = new ArrayList<>();
}
