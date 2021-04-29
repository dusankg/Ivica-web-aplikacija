import { Component, OnInit } from '@angular/core';
import { Apartment } from '../model/Apartment';
import { ApartmentService } from '../services/apartment-service';

@Component({
  selector: 'app-lista-apartmana',
  templateUrl: './lista-apartmana.component.html',
  styleUrls: ['./lista-apartmana.component.css']
})
export class ListaApartmanaComponent implements OnInit {

  public allApartments: Set<Apartment>


  positionMap = {
    street: "Jirecekova",
    num: "5",
    city: "Novi Sad"
  };
  mapsURL = `https://maps.google.com/maps?q=${this.positionMap.street}%20${this.positionMap.num}%20%${this.positionMap.city}&t=&z=20&ie=UTF8&iwloc=&output=embed`;
  
  brojevi = [1,2,3,4,5]
  constructor(private apartmentService: ApartmentService) { }

  ngOnInit(): void {
    //console.log(this.brojevi)
    this.getAllActiveApartments()
  }

  public getAllActiveApartments(){
    this.apartmentService.getAllActiveApartments().subscribe( response => {
      this.allApartments = response;
      console.log(response);
    })
  }

  public isForSale(apartman: Apartment){
    return apartman.forSale
  }

}
