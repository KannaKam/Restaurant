package com.olgibaba.restaurant.buisness.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CartRequest {
    private int id;
    private CartItemRequest[] itemsRequest;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CartItemRequest[] getItemsRequest() {
        return itemsRequest;
    }

    public void setItemsRequest(CartItemRequest[] itemsRequest) {
        this.itemsRequest = itemsRequest;
    }
}
