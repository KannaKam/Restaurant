package com.olgibaba.restaurant.controllers;

import com.olgibaba.restaurant.buisness.entities.Category;
import com.olgibaba.restaurant.buisness.services.UserRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/restaurant")
public class UserRestaurantController {

    @Autowired
    UserRestaurantService userRestaurantService;

    @GetMapping("getCategories")
    public ResponseEntity<?> getCategories (){
        List<Category> categories = userRestaurantService.categoriesList();
        return new ResponseEntity(categories, HttpStatus.OK);
    }

}
