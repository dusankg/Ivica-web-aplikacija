import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login-component/login-service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
    this.loginService.whoAmI().subscribe( response => {
      localStorage.setItem('role', 'ROLE_USER')
      response.authorities.forEach(element => {        
        if (element.authority === "ROLE_ADMIN"){
          alert("Hello Admin")
          localStorage.removeItem('role');
          localStorage.setItem('role', 'ROLE_ADMIN')
        }
      });
    })
    console.log(localStorage.getItem('role'))

  }

}
