import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-validate-account',
  templateUrl: './validate-account.component.html',
  styleUrls: ['./validate-account.component.css']
})
export class ValidateAccountComponent implements OnInit {

  public validationUsername: string;
  public validationPassword: string;
  public validationCode: number;
  constructor() { }

  ngOnInit(): void {
  }

  // TODO Slanje validacije na back
  finishRegistration(){

  }

}
