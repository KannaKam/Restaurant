package com.olgibaba.restaurant.persistence;

import com.olgibaba.restaurant.buisness.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Boolean existsByMail(String mail);

    Optional<Admin> findAdminByMail(String mail);

}
