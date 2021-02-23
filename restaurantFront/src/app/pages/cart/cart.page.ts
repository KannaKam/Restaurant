import { Component, OnInit } from '@angular/core';
import { Storage } from '@ionic/storage';
import { UserRestaurantService } from '../../services/user-restaurant.service';
import { Router } from '@angular/router';
import { Cart, Products, UserRestaurant, CartItem, CartRequest } from '../../interfaces/interfaces';
import { CartService } from 'src/app/services/cart.service';
import { element } from 'protractor';
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.page.html',
  styleUrls: ['./cart.page.scss'],
})
export class CartPage implements OnInit {

  constructor(private storage: Storage, private userRestaurantService: UserRestaurantService, private router: Router, private cartService: CartService,private alertController:AlertController) { }

  public cart: Cart;
  public userRestaurant: UserRestaurant;
  public finalPrice: number;
  public cartRequest: CartRequest={
    itemsRequest:[],
    id:0
  };

  ngOnInit() {
    this.getCart();
    this.getRestaurant();
  }

  async getCart() {
    await this.cartService.getCart().then(resp => {
      if (resp != null) {
        this.cart = resp;
        this.finalPriceCalc();
      }
    })
  }

  async getRestaurant() {
    const resp = await this.storage.get('userRestaurant');
    if (resp) {
      this.userRestaurant = resp;
    }
  }

  finalPriceCalc() {
    this.finalPrice = 0;
    for (let index = 0; index < this.cart.items.length; index++) {
      this.finalPrice += this.cart.items[index].product.price * this.cart.items[index].quantity;
    }
  }

  buy() {
    this.cartRequest.itemsRequest=[];
    if (this.cart.items.length != 0) {
      this.cart.items.forEach(element => {
        this.cartRequest.itemsRequest.push({
          id: element.product.id,
          quantity: element.quantity
        })
      });
      this.cartRequest.id = this.userRestaurant.id;
      this.userRestaurantService.buy(this.cartRequest).subscribe(data=>{
        if(data){
          this.cart.items=[];
          this.setCart();
          this.presentAlertSuccess();
        }
      },error=>{
          this.presentAlertFailed(error.error.message);
      });
    }

  }

  addQuantity(product: Products) {
    const index = this.cart.items.findIndex(prod => prod.product.name == product.name);

    if (index > -1) {
      this.cart.items[index].quantity += 1
      this.finalPriceCalc();
      this.setCart();
    }
  }

  sustractQuantity(product: Products) {
    const index = this.cart.items.findIndex(prod => prod.product.name == product.name);

    if (index > -1) {
      if (this.cart.items[index].quantity > 1) {
        this.cart.items[index].quantity -= 1
        this.finalPriceCalc();
        this.setCart();
      }
    }
  }
  async setCart() {
    await this.cartService.setCart(this.cart);
  }

  removeItemFromCart(cartItem: CartItem) {
    const index = this.cart.items.indexOf(cartItem);
    if (index > -1) {
      this.cart.items.splice(index, 1);
    }
    this.setCart();
    this.finalPriceCalc();
  }

  async presentAlertSuccess() {
    const alert = await this.alertController.create({
      cssClass: 'my-custom-class',
      header: 'Success',
      message: 'Payment confirmed',
      buttons: [{
        text:"Ok",
        handler:()=>{
          alert.dismiss();
          this.router.navigate(['/home']);
        }
      }]
    });

    await alert.present();
  }
  async presentAlertFailed(message:string) {
    const alert = await this.alertController.create({
      cssClass: 'my-custom-class',
      header: 'Failure',
      message: message,
      buttons: [{
        text:"Ok",
        handler:()=>{
          alert.dismiss();
        }
      }]
    });

    await alert.present();
  }
}
