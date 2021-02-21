import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserRestaurant, UserLoginRequest } from '../interfaces/interfaces';

@Injectable({
  providedIn: 'root'
})
export class AccountServiceService {

  constructor(private httpClient: HttpClient) { }

  private url = 'http://localhost:8085/account/';

  signIn(signIn: UserLoginRequest) {

    return this.httpClient.post<UserRestaurant>(this.url + "userSignIn", signIn);
  }

  signUp(signUp: UserRestaurant) { 
    return this.httpClient.post(this.url + "userSignUp", signUp);
  }
}
