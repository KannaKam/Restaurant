package com.olgibaba.supplier.buisness.entities;

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
    @MapsId("id")
    private Products products;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_id")
    @MapsId("id")
    private Orders orders;

    @Column(name = "units")
    private int units;


}
