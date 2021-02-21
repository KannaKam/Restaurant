import { Injectable } from '@angular/core';
import { Storage } from '@ionic/storage';
import { Cart } from '../interfaces/interfaces';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private storage:Storage) { }

  getCart(){
    return this.storage.get('cart');
  }

  setCart(cart:Cart){
    return this.storage.set('cart', cart);
  }

  
}
