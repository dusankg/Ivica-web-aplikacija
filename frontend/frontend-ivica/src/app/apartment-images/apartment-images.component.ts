import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SlikeSetByte } from '../model/SlikeSetByte';
import { ApartmentService } from '../services/apartment-service';

@Component({
  selector: 'app-apartment-images',
  templateUrl: './apartment-images.component.html',
  styleUrls: ['./apartment-images.component.css']
})
export class ApartmentImagesComponent implements OnInit {

  constructor(private apartmentServise: ApartmentService, private route: ActivatedRoute) { }

  private apartmentId: number;
  public slikaZaPrikaz: string;
  public nizSlika: string[]

  public hiddenBigImage: boolean = true;

  ngOnInit(): void {
    this.apartmentId = Number(this.route.snapshot.paramMap.get("apartmentId"))
    this.apartmentServise.getApartmentImages(this.apartmentId).subscribe(
      response =>{
        this.nizSlika = Array.from(response.slike)
      }
    );
  }

  public showImage(image){
    this.slikaZaPrikaz = image;
    this.hiddenBigImage = false;
  }

  public nextImage(){
    var index = this.nizSlika.indexOf(this.slikaZaPrikaz)
    index += 1;
    if(index >= this.nizSlika.length){
      index = 0;
    }
    this.slikaZaPrikaz = this.nizSlika[index];
  }

  public previousImage(){
    var index = this.nizSlika.indexOf(this.slikaZaPrikaz)
    index -= 1;
    if(index < 0){
      index = this.nizSlika.length - 1;
    }
    this.slikaZaPrikaz = this.nizSlika[index];
  }

  public closeBigImage(){
    this.hiddenBigImage = true;
  }

}
