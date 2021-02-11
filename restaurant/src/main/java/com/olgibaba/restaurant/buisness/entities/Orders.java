package com.olgibaba.restaurant.buisness.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.sql.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ord_date")
    private Date ordDate;

    @Column(name = "sent")
    @Min(0) @Max(1)
    @NonNull
    private int sent;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference
    private UserRestaurant restaurant;

    @OneToMany(mappedBy = "orders")
    @JsonManagedReference(value = "orders")
    private Set<OrderedProducts> orderedProducts;
}
