import { Component, OnInit } from '@angular/core';
import { ApartmentService } from '../services/apartment-service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ApartmentForRentDTO } from '../model/ApartmentForRentDTO';
import { LocationDTO } from '../model/LocationDTO';

@Component({
  selector: 'app-add-apartment-for-rent',
  templateUrl: './add-apartment-for-rent.component.html',
  styleUrls: ['./add-apartment-for-rent.component.css']
})
export class AddApartmentForRentComponent implements OnInit {

  public brojac: number;
  public base64Image: Blob;
  public base64Images: Set<Blob>;

  public tumbnail: string;

  public formaUnos: FormGroup;
  confirmedUserConditions: boolean;

  constructor(private formBuilder: FormBuilder, private router: Router, private apartmentService: ApartmentService) { 
    this.base64Images = new Set<Blob>();
  }

  ngOnInit(): void {
    this.confirmedUserConditions = false;
    this.formaUnos = this.formBuilder.group({
      guestsNumber: [0, Validators.required],
      roomsNumber: [0, Validators.required],
      street: ['', Validators.required],
      number: ['', Validators.required],

      city: ['', Validators.required],
      postalCode: [0, Validators.required],
      price_per_night: ['', Validators.required],
      check_in_time: ['', Validators.required],
      check_out_time: ['', Validators.required],

      description: ['', Validators.required],
      keyWords: ['', Validators.required],

      });
  }

  get f() { return this.formaUnos.controls; }

  // SLIKE
  changeListenerTumbnail($event): void {
    this.readThisTumbnail($event.target);
  }

  readThisTumbnail(inputValue: any): void {
    var file: File = inputValue.files[0];
    var myReader: FileReader = new FileReader();

    myReader.onloadend = (e) => {
      this.tumbnail = myReader.result as unknown as string;
      this.apartmentService.compressImageSirina(this.tumbnail, 340).then(compressed => {
        this.tumbnail = compressed as string;
      })
    }
    myReader.readAsDataURL(file);

  }

  changeListener($event): void {
    this.readThis($event.target);
  }

  readThis(inputValue: any): void {
    var file: File = inputValue.files[0];
    var myReader: FileReader = new FileReader();

    myReader.onloadend = (e) => {
      this.base64Image = myReader.result as unknown as Blob;
      this.base64Images.add(myReader.result as unknown as Blob);
      //this.carDTO.images.push(myReader.result as string);
    }
    myReader.readAsDataURL(file);

  }
  removeImage(imageName: Blob){
    this.base64Images.delete(imageName);
  }

  sendImages(apartmentId: number = 1){
    this.apartmentService.uploadPhotos(apartmentId, this.base64Images).subscribe();
  }
  // KRAJ SLIKA

  public onSubmit(){
    console.log(this.formaUnos)

    var apartmanZaSlanje: ApartmentForRentDTO = new ApartmentForRentDTO();

    apartmanZaSlanje.check_in_time = this.f.check_in_time.value;

    apartmanZaSlanje.check_out_time = this.f.check_out_time.value;

    apartmanZaSlanje.roomsNumber = this.f.roomsNumber.value;

    apartmanZaSlanje.guestsNumber = this.f.guestsNumber.value;

    apartmanZaSlanje.price_per_night = this.f.price_per_night.value;

    apartmanZaSlanje.tumbnail = this.tumbnail;

    var lokacija: LocationDTO = new LocationDTO();

    lokacija.city = this.f.city.value;

    lokacija.street = this.f.street.value;

    lokacija.number = this.f.number.value;

    lokacija.postalCode = this.f.postalCode.value;
    
    lokacija.googleMapsUrl = `https://maps.google.com/maps?q=${this.f.street.value}%20${this.f.number.value}%20%${this.f.city.value}&t=&z=20&ie=UTF8&iwloc=&output=embed`;


    apartmanZaSlanje.location = lokacija;

    console.log(apartmanZaSlanje)

    this.apartmentService.saveApartmentForRent(apartmanZaSlanje).subscribe(
      response =>{
        this.sendImages(response);
      }
    );

    

  }





}
