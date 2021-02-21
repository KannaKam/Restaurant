package com.olgibaba.restaurant.controllers;

import com.olgibaba.restaurant.buisness.entities.*;
import com.olgibaba.restaurant.buisness.payload.request.CartItemRequest;
import com.olgibaba.restaurant.buisness.payload.request.CartRequest;
import com.olgibaba.restaurant.buisness.payload.response.ResponseMessages;
import com.olgibaba.restaurant.buisness.services.UserRestaurantService;
import com.olgibaba.restaurant.persistence.OrderedProductsRepository;
import com.olgibaba.restaurant.persistence.OrdersRepository;
import com.olgibaba.restaurant.persistence.ProductsRepository;
import com.olgibaba.restaurant.persistence.UserRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/restaurant")
public class UserRestaurantController {

    @Autowired
    UserRestaurantService userRestaurantService;
    @Autowired
    UserRestaurantRepository userRestaurantRepository;
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    OrderedProductsRepository orderedProductsRepository;
    @Autowired
    OrdersRepository ordersRepository;

    @GetMapping("getCategories")
    public ResponseEntity<?> getCategories (){
        List<Category> categories = userRestaurantService.categoriesList();
        return new ResponseEntity(categories, HttpStatus.OK);
    }

    @PostMapping("/buy")
    public ResponseEntity<?> buy(@RequestBody CartRequest cartRequest){

        Orders order = new Orders();
        Optional<UserRestaurant> userRestaurantOptional = userRestaurantRepository.findById(cartRequest.getId());

        if(!userRestaurantOptional.isPresent()){
            return ResponseEntity.badRequest().body(new ResponseMessages(404,"Error","Restaurant not found"));
        }

        UserRestaurant restaurant = userRestaurantOptional.get();
        order.setRestaurant(restaurant);
        Date sqlDate = new Date(new java.util.Date().getTime());
        order.setOrdDate(sqlDate);
        order.setSent(0);

        List<Products> productsList = productsRepository.findAllByIdInOrderByIdAsc(Arrays.stream(cartRequest.getItemsRequest()).map(CartItemRequest::getId).collect(Collectors.toList()));
        Arrays.sort(cartRequest.getItemsRequest(), Comparator.comparingInt(CartItemRequest::getId));

        for (int i = 0; i < cartRequest.getItemsRequest().length; i++) {
            if (cartRequest.getItemsRequest()[i].getQuantity()<=productsList.get(i).getStock()){
                productsRepository.save(productsList.get(i));
                OrderedProducts orderedProducts = new OrderedProducts();
                orderedProducts.setOrders(order);
                productsRepository.save(productsList.get(i));
                orderedProducts.setProducts(productsList.get(i));
                ordersRepository.save(order);
                orderedProducts.setUnits(cartRequest.getItemsRequest()[i].getQuantity());
                orderedProductsRepository.save(orderedProducts);
                productsList.get(i).setStock(productsList.get(i).getStock()-cartRequest.getItemsRequest()[i].getQuantity());

            }else {
                return ResponseEntity.badRequest().body(new ResponseMessages(409,"Error","Insufficient stock"));
            }

        }
         return ResponseEntity.ok().body(new ResponseMessages(200,"Ok","Purchase done correctly"));
    }

}
