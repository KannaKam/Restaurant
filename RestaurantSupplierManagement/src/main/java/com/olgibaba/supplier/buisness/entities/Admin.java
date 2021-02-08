package com.olgibaba.supplier.buisness.entities;

import lombok.*;
import org.hibernate.validator.constraints.Length;

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

    @Column(name = "mail", unique = true, length = 200)
    @Length(max = 200)
    @NotBlank
    private String mail;

    @Column(name = "password", length = 45)
    @Length(max = 45)
    @NotBlank
    private String password;
}
