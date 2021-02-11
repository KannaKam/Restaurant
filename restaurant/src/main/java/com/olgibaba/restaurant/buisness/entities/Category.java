package com.olgibaba.restaurant.buisness.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", unique = true, length = 45)
    @Length(max = 45)
    @NotBlank
    private String name;

    @Column(name = "description", length = 200)
    @Length(max = 200)
    private String description;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<Products> productsList = new ArrayList<>();
}
