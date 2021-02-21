import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AlertController } from '@ionic/angular';
import { UserRestaurant } from 'src/app/interfaces/interfaces';
import { AccountServiceService } from '../../services/account-service.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.page.html',
  styleUrls: ['./sign-up.page.scss'],
})
export class SignUpPage implements OnInit {

  public signUpForm: FormGroup;
  constructor(private formBuilder: FormBuilder, private accountService:AccountServiceService, public alertController: AlertController, private router:Router) { }

  private userRestaurant: UserRestaurant;

  ngOnInit() {
    this.createForm();
  }

  signUp(){
    if(this.signUpForm.invalid) return
    this.userRestaurant = this.signUpForm.value;

    this.accountService.signUp(this.userRestaurant).subscribe(
      data => {
        if(data){
          this.presentAlert();
        }
      }
    ) 

  }

  async presentAlert() {
    const alert = await this.alertController.create({
      cssClass: 'my-custom-class',
      header: 'Success',
      message: 'Signed up succesfully.',
      buttons: [{
        text:"Ok",
        handler:()=>{
          alert.dismiss();
          this.router.navigate(['/sign-in']);
        }
      }]
    });

    await alert.present();
  }

  get mail() {
    return this.signUpForm.get('mail')
  }
  get password() {
    return this.signUpForm.get('password')
  }
  get country() {
    return this.signUpForm.get('country')
  }
  get city() {
    return this.signUpForm.get('city')
  }
  get address() {
    return this.signUpForm.get('address')
  }
  get postcode() {
    return this.signUpForm.get('postcode')
  }

  createForm() {
    this.signUpForm = this.formBuilder.group({
      mail: ['', [Validators.required, Validators.email, Validators.maxLength(50)]],
      password: ['', [Validators.required, Validators.minLength(4),
      Validators.maxLength(200)]],
      country: ['', [Validators.required, Validators.maxLength(50)]],
      city: ['', [Validators.required, Validators.maxLength(50)]],
      address: ['', [Validators.required, Validators.maxLength(50)]],
      postcode: ['', [Validators.required, Validators.pattern('^([0-9]{5})$')]]
    })
  }

  validationMessages = {
    'mail': [
      { type: 'required', message: 'Required' },
      { type: 'maxlength', message: 'Max length of 90 characters' },
      { type: 'email', message: 'Not a valid email address' },
    ],
    'password': [
      { type: 'required', message: 'Required' },
      { type: 'minlength', message: 'Min length of 4 characters' },
      { type: 'maxlength', message: 'Max length of 45 characters' }
    ],
    'country': [
      { type: 'required', message: 'Required' },
      { type: 'maxlength', message: 'Max length of 45 characters' },
    ],
    'city': [
      { type: 'required', message: 'Required' },
      { type: 'maxlength', message: 'Max length of 45 characters' },
    ],
    'address': [
      { type: 'required', message: 'Required' },
      { type: 'maxlength', message: 'Max length of 200 characters' },
    ],
    'postcode': [
      { type: 'required', message: 'Required' },
      { type: 'pattern', message: '5 numbers' },
    ]
  }

}
