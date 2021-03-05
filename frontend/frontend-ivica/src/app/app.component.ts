import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  title = 'frontend-ivica';
  public hideHeader: boolean;
  constructor(private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    console.log(this.router.url)
  }

}

