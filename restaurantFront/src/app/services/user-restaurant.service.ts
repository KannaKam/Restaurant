import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserRestaurantService {

  constructor(private httpClient:HttpClient) { }

  private url = "http://localhost:8090/restaurant/";

  getCategories(){
    return this.httpClient.get<any>(this.url + "getCategories");
  }
}

