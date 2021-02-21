package com.olgibaba.restaurant.buisness.services;

import com.olgibaba.restaurant.buisness.entities.Category;
import com.olgibaba.restaurant.buisness.entities.Products;
import com.olgibaba.restaurant.buisness.entities.UserRestaurant;
import com.olgibaba.restaurant.persistence.CategoryRepository;
import com.olgibaba.restaurant.persistence.ProductsRepository;
import com.olgibaba.restaurant.persistence.UserRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRestaurantServiceImpl implements UserRestaurantService{

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    UserRestaurantRepository userRestaurantRepository;

    @Override
    public List<Category> categoriesList() {
        return categoryRepository.findAll();
    }


}
