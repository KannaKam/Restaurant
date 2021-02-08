package com.olgibaba.supplier.buisness.services;

import com.olgibaba.supplier.buisness.entities.Category;
import com.olgibaba.supplier.buisness.entities.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRestaurantService {

    List<Products> productsList();
    List<Category> categoriesList();

}
