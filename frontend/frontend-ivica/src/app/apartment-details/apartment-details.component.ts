import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApartmentService } from '../services/apartment-service';


@Component({
  selector: 'app-apartment-details',
  templateUrl: './apartment-details.component.html',
  styleUrls: ['./apartment-details.component.css']
})
export class ApartmentDetailsComponent implements OnInit {

  constructor(private apartmentServise: ApartmentService, private route: ActivatedRoute) { }


  private apartmentId: number;


  ngOnInit(): void {

    this.apartmentId = Number(this.route.snapshot.paramMap.get("apartmentId"))
    this.apartmentServise.getApartmentImages(this.apartmentId).subscribe(
      response =>{
        this.nizSlika = Array.from(response.slike)
      }
    );

  }

}
