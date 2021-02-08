package com.olgibaba.supplier.persistence;

import com.olgibaba.supplier.buisness.entities.OrderedProducts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedProductsRepository extends CrudRepository<OrderedProducts, Integer> {
}
