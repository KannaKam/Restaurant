package com.olgibaba.supplier.persistence;

import com.olgibaba.supplier.buisness.entities.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends CrudRepository <Admin, Integer> {

    Boolean checkExistence(String mail);

    Optional<Admin> findAdminByMail(String mail);

}
