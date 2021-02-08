package com.olgibaba.supplier.persistence;

import com.olgibaba.supplier.buisness.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
