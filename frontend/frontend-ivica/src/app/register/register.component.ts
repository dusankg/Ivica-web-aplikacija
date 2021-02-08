import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
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
  
  constructor() { }

  ngOnInit(): void {
  }

}
