import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {
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
