import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {

  loginForm!: FormGroup;


  constructor( private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit(): void {

  }


  login(){
    alert("Login")
  }

}
