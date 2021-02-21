package com.olgibaba.restaurant.buisness.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CartItemRequest {

    private int id;
    private int quantity;

}
