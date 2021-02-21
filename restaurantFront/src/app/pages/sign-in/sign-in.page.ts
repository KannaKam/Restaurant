import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AlertController } from '@ionic/angular';
import { Storage } from '@ionic/storage';
import { AccountServiceService } from 'src/app/services/account-service.service';
import { Cart, UserLoginRequest, UserRestaurant } from '../../interfaces/interfaces';
import { CartService } from '../../services/cart.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.page.html',
  styleUrls: ['./sign-in.page.scss'],
})
export class SignInPage implements OnInit {

  public signInForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private accountService:AccountServiceService, public alertController: AlertController, private storage:Storage, private router:Router, private cartService:CartService) { }

  private userRestaurant: UserLoginRequest;
  private user:UserRestaurant;
  private cart:Cart = {
    items:[]
  };

  ngOnInit() {
    this.createForm();
    this.storage.clear();
  }

  signIn(){
    if(this.signInForm.invalid) return
    this.userRestaurant = this.signInForm.value;

    this.accountService.signIn(this.userRestaurant).subscribe(
      data => {
        if(data){
          this.user=data;
          this.storage.set('userRestaurant', this.user);
          this.cartService.setCart(this.cart);
          this.presentAlertSuccess();
        }
      }, error => {
        this.presentAlertFailed();
      }
    )
  }

  async presentAlertSuccess() {
    const alert = await this.alertController.create({
      cssClass: 'my-custom-class',
      header: 'Success',
      message: 'Signed in succesfully.',
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
  async presentAlertFailed() {
    const alert = await this.alertController.create({
      cssClass: 'my-custom-class',
      header: 'Error',
      message: 'Wrong credentials.',
      buttons: ['OK']
    });

    await alert.present();
  }

  get mail() {
    return this.signInForm.get('mail')
  }
  get password() {
    return this.signInForm.get('password')
  }

  createForm() {
    this.signInForm = this.formBuilder.group({
      mail: ['', [Validators.required, Validators.email, Validators.maxLength(50)]],
      password: ['', [Validators.required, Validators.minLength(4),
      Validators.maxLength(200)]]
    })
  }

  validationMessages = {
    'mail': [
      { type: 'required', message: 'Required' },
      { type: 'maxlength', message: 'Max length of 200 characters' },
      { type: 'email', message: 'Not a valid email address' },
    ],
    'password': [
      { type: 'required', message: 'Required' },
      { type: 'minlength', message: 'Min length of 4 characters' },
      { type: 'maxlength', message: 'Max length of 45 characters' }
    ]
  }

}
