package com.olgibaba.restaurant.persistence;

import com.olgibaba.restaurant.buisness.entities.UserRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRestaurantRepository extends JpaRepository<UserRestaurant, Integer> {

    boolean existsByMail(String mail);

    Optional<UserRestaurant> findUserRestaurantByMail(String mail);

}
