package com.olgibaba.supplier.persistence;

import com.olgibaba.supplier.buisness.entities.UserRestaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRestaurantRepository extends CrudRepository<UserRestaurant, Integer> {
}
