package com.olgibaba.restaurant.buisness.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 45)
    @Length(max = 45)
    private String name;

    @Column(name = "description", length = 90)
    @Length(max = 90)
    private String description;

    @Column(name = "weight")
    private double weight;

    @Column(name = "stock")
    private int stock;

    @Column(name = "price")
    private double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;

    @OneToMany(mappedBy = "products")
    @JsonManagedReference(value = "products")
    private Set<OrderedProducts> orderedProducts;
}
