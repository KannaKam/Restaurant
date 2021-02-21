package com.olgibaba.restaurant.persistence;

import com.olgibaba.restaurant.buisness.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
    List<Products> findAllByIdInOrderByIdAsc(Collection<Integer> id);
}
