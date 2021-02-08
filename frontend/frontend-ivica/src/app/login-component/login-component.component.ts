import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtAutenticationRequest } from '../model/JwtAuthenticationRequest';
import { LoginService } from './login-service';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {


  title = 'frontend-agent';
  email: string;
  password: string;
  confirmPassword: string;

  show = false;

  hideLoginBox: boolean;
  hideNewPasswordBox: boolean;
  hideValidateBox: boolean;

  validationCode: number;
  validationEmail: string;
  //request: ResetPasswordDTO;
  //validation: ValidationDTO;

  constructor( private formBuilder: FormBuilder, private router: Router, private loginService: LoginService) { }

  ngOnInit(): void {

  }

  showNewPasswordBox(){
    this.hideNewPasswordBox = false;
    this.hideLoginBox = true;
  }

  public login(){
    var authRequest: JwtAutenticationRequest = new JwtAutenticationRequest();
    
    authRequest.username = this.email;
    authRequest.password = this.password;

    this.loginService.login(authRequest).subscribe(response => {
      console.log(response);
      localStorage.setItem('jwt', response.accessToken);
      this.router.navigate(['homePage']);
    },
    err => {
      if (err.status === 400) {
        alert('Wrong password');
      } else if (err.status === 406 || err.status === 403 || err.status === 401) {
        alert('Wrong password');
      }
      else {
        alert('something gone wrong');
      }
    });
  }

  /*sendValidationCode(){
   
    this.request.username = this.email;
    if(this.password !== this.confirmPassword){
      alert('Passwords dont match');
      return;
    }
    this.request.password = this.password;
    this.loginService.sendRequest(this.request).subscribe();
    this.hideNewPasswordBox = true;
    this.hideValidateBox = false;
  
  }*/

  finishValidation(){
    /*this.validation.username = this.validationEmail;
    this.validation.validationCode = this.validationCode;
    this.loginService.validate(this.validation).subscribe(response => {
      alert('Now, you can login');
      this.router.navigate(['login']);
    }, err => alert(err.status + ": Validation code is invalid"));
    */
  }

}
