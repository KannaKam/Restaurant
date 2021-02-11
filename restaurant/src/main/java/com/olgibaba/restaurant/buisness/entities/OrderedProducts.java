package com.olgibaba.restaurant.buisness.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "orderedproducts")
public class OrderedProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "products_id")
    @JsonBackReference(value = "products")
    private Products products;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_id")
    @JsonBackReference(value = "orders")
    private Orders orders;

    @Column(name = "units")
    private int units;


}
