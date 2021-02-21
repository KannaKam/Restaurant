import { Component, Input, OnInit } from '@angular/core';
import { ModalController, AlertController } from '@ionic/angular';
import { Storage } from '@ionic/storage';
import { Cart, Category, Products } from '../../interfaces/interfaces';
import { CartService } from '../../services/cart.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-modal',
  templateUrl: './product-modal.page.html',
  styleUrls: ['./product-modal.page.scss'],
})
export class ProductModalPage implements OnInit {

  constructor(private modalController: ModalController, private cartService: CartService, private alertController: AlertController,private router:Router) { }
  private cart: Cart;

  @Input() category: Category;

  ngOnInit() {
    this.resetQuantity();
  }

  async addToCart(product: Products, quantity: number) {
    let flag = false;
    await this.cartService.getCart().then(resp => {
      this.cart = resp;
      if (this.cart.items.length == 0) {
        flag = false;
      } else {
        this.cart.items.forEach(element => {
          if (element.product.name == product.name) {
            flag = true;
          }
        })
      }
      if (flag == false) {
        this.cart.items.push({
          product,
          quantity
        })
        this.presentAlertSuccess();
        this.cartService.setCart(this.cart);
        this.resetQuantity();
      } else {
        this.presentAlertFailed("Product alredy listed to cart.");
      }
    });
  }

  async presentAlertFailed(message:string) {
    const alert = await this.alertController.create({
      cssClass: 'my-custom-class',
      header: 'Error',
      message: message,
      buttons: [{
        text: "Ok",
        handler: () => {
          alert.dismiss();
        }
      }]
    });

    await alert.present();
  }

  async presentAlertSuccess() {
    const alert = await this.alertController.create({
      cssClass: 'my-custom-class',
      header: 'Success',
      message: 'Product added to cart.',
      buttons: [{
        text: "Ok",
        handler: () => {
          alert.dismiss();
        }
      },
      {
        text: "Go to cart",
        handler: () => {
          alert.dismiss(),
          this.modalController.dismiss(),
          this.router.navigate(['/cart']);
        }
      }]
    });

    await alert.present();
  }

  async exit() {
    await this.modalController.dismiss();
  }

  resetQuantity() {
    this.category.productsList.forEach(element => {
      element.quantity = 0;
    })
  }

  addQuantity(product: Products) {
    product.quantity += 1;
  }

  sustractQuantity(product: Products) {
    if(product.quantity==0){
      this.presentAlertFailed("Quantity can not be a negative number.")
    }else{
      product.quantity -= 1;
    }
  }

}
