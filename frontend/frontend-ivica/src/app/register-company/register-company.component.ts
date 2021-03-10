import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserRequestCompany } from '../model/UserRequestCompany';
import { RegisterService } from '../register/registerService'

@Component({
  selector: 'app-register-company',
  templateUrl: './register-company.component.html',
  styleUrls: ['./register-company.component.css']
})
export class RegisterCompanyComponent implements OnInit {

  registerForm: FormGroup;
  submitted = false;

  confirmedUserConditions: boolean;

  constructor(private formBuilder: FormBuilder, private router: Router,  private registerService: RegisterService) { }

  ngOnInit(): void {
    this.confirmedUserConditions = false
    this.registerForm = this.formBuilder.group({
      username: ['', Validators.required],
      nazivAgencije: ['', Validators.required],
      pib: ['', Validators.required],
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

    var userRequestCompany: UserRequestCompany = new UserRequestCompany;
    userRequestCompany.username = this.f.username.value
    userRequestCompany.name = this.f.nazivAgencije.value
    userRequestCompany.pib = this.f.pib.value
    userRequestCompany.email = this.f.email.value
    userRequestCompany.password = this.f.password.value

    console.log(userRequestCompany)
    
    this.registerService.signUpCompany(userRequestCompany).subscribe( response => {
      alert("Validacioni kod je poslat na Vasu e-mail adresu");
      this.router.navigate(['login']);
 
    })
    

  }


}
