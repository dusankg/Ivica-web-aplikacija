import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-page-search',
  templateUrl: './home-page-search.component.html',
  styleUrls: ['./home-page-search.component.css']
})
export class HomePageSearchComponent implements OnInit {

  public pretraga: String;
  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  public pretrazi(){
    this.router.navigate(["listaApartmana"]);
  }
}
