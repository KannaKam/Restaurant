package com.olgibaba.supplier.buisness.entities;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "mail", unique = true)
    @NotBlank
    private String mail;

    @Column(name = "password")
    @NotBlank
    private String password;
}
