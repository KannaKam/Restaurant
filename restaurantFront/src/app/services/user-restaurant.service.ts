import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CartRequest, ResponseMessage } from '../interfaces/interfaces';

@Injectable({
  providedIn: 'root'
})
export class UserRestaurantService {

  constructor(private httpClient:HttpClient) { }

  private url = "http://localhost:8095/restaurant/";

  getCategories(){
    return this.httpClient.get<any>(this.url + "getCategories");
  }

  buy(cart:CartRequest){
    return this.httpClient.post(this.url + "buy", cart);
  }
}

