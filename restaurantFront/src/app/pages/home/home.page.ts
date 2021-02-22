import { Component } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { Storage } from '@ionic/storage';
import { Category, UserRestaurant } from 'src/app/interfaces/interfaces';
import { UserRestaurantService } from '../../services/user-restaurant.service';
import { Products } from '../../interfaces/interfaces';
import { ProductModalPage } from '../product-modal/product-modal.page';

@Component({
  selector: 'app-home',
  templateUrl: './home.page.html',
  styleUrls: ['./home.page.scss'],
})
export class HomePage{

  constructor(private storage:Storage, private userRestaurantService:UserRestaurantService, private modalController:ModalController) { }

  public userRestaurant: UserRestaurant = {};
  public categories: Category [] = [];
  public products: Products[] = [];

  ionViewWillEnter(){
    this.loadRestaurant();
    this.getCategories();
  }

  async loadRestaurant() {
    const rest = await this.storage.get('restaurant')
    if(rest){
      this.userRestaurant=rest;
    }
  }

  async getCategories(){
    await this.userRestaurantService.getCategories().subscribe(
      data => {
        this.categories = data;
      }
    )
  }

  async getProducts(category: Category){
    const modal = await this.modalController.create({
      component: ProductModalPage,
      cssClass: 'my-custom-modal-css',
      componentProps: {
        category
      }
    })
    await modal.present();
  }


}
