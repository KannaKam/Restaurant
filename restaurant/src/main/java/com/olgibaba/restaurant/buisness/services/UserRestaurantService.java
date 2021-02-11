package com.olgibaba.restaurant.buisness.services;

import com.olgibaba.restaurant.buisness.entities.Category;
import com.olgibaba.restaurant.buisness.entities.Products;

import java.util.List;

public interface UserRestaurantService {

    List<Products> productsList();
    List<Category> categoriesList();

}
