package com.olgibaba.restaurant.buisness.services;

import com.olgibaba.restaurant.buisness.entities.Category;
import com.olgibaba.restaurant.buisness.entities.Products;
import com.olgibaba.restaurant.persistence.CategoryRepository;
import com.olgibaba.restaurant.persistence.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRestaurantServiceImpl implements UserRestaurantService{

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductsRepository productsRepository;

    @Override
    public List<Products> productsList() {
        return productsRepository.findAll();
    }

    @Override
    public List<Category> categoriesList() {
        return categoryRepository.findAll();
    }
}
