package com.olgibaba.restaurant.persistence;

import com.olgibaba.restaurant.buisness.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
}
