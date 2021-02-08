package com.olgibaba.supplier.persistence;

import com.olgibaba.supplier.buisness.entities.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Integer> {
}
