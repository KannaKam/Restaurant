package com.olgibaba.restaurant.persistence;

import com.olgibaba.restaurant.buisness.entities.OrderedProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedProductsRepository extends JpaRepository<OrderedProducts, Integer> {
}
