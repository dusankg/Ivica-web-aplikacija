import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserRequest } from '../model/UserRequest';
import { RegisterService } from './registerService';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  submitted = false;

  confirmedUserConditions: boolean;

  constructor(private formBuilder: FormBuilder, private router: Router,  private registerService: RegisterService) { }

  ngOnInit(): void {
    this.confirmedUserConditions = false
    this.registerForm = this.formBuilder.group({
      username: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email,Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', [Validators.required, Validators.minLength(6)]]
      });
  }

  get f() { return this.registerForm.controls; }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.registerForm.invalid) {
        return;
    }
}

  public sendValidationCode(){

    console.log(this.confirmedUserConditions)
    if (this.f.password.value !== this.f.confirmPassword.value){
      alert("Sifre se ne poklapaju");
      return;
    }

    var userRequest: UserRequest = new UserRequest;
    userRequest.username = this.f.username.value
    userRequest.firstname = this.f.firstName.value
    userRequest.lastname = this.f.lastName.value
    userRequest.email = this.f.email.value
    userRequest.password = this.f.password.value

    
    this.registerService.signUp(userRequest).subscribe( response => {
      alert("Validacioni kod je poslat na Vasu e-mail adresu");
      this.router.navigate(['login']);
 
    })


  }

}
