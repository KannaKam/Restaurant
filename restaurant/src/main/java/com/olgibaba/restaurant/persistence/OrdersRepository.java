package com.olgibaba.restaurant.persistence;

import com.olgibaba.restaurant.buisness.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}
