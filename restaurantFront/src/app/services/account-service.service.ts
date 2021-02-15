import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserRestaurant } from '../interfaces/interfaces';

@Injectable({
  providedIn: 'root'
})
export class AccountServiceService {

  constructor(private httpClient: HttpClient) { }

  private url = 'http://localhost:8090/restaurant/';

  signIn(signIn: Credential) {

    return this.httpClient.post<any>(this.url + "userSignIn", signIn);
  }

  signUp(signUp: UserRestaurant) { 
    return this.httpClient.post(this.url + "userSignUp", signUp);
  }
}
