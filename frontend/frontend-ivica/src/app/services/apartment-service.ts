
import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import { SlikeSetByte } from '../model/SlikeSetByte';
import { ApartmentForRentDTO } from '../model/ApartmentForRentDTO';


@Injectable()
export class ApartmentService {
  private readonly apartmentUrl: string;
  private readonly apartmentForRentUrl: string;

  constructor(private http: HttpClient) {
    this.apartmentUrl = 'http://localhost:8080/apartment';
    this.apartmentForRentUrl = 'http://localhost:8080/apartmentForRent';
  }


  public getAllActiveApartments(){
    return this.http.get<any>(this.apartmentUrl + '/activeAll');
  }

  public saveApartmentForRent(apartmanZaSlanje: ApartmentForRentDTO){

    const headerDict = {
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('jwt')
    };
    
    const requestOptions = {                                                                                                                                                                                 
      headers: new HttpHeaders(headerDict), 
    };

    return this.http.post<any>(this.apartmentForRentUrl, apartmanZaSlanje, requestOptions);
  }
  
  public compressImageObeOse(src, newX, newY) {
    return new Promise((res, rej) => {
      const img = new Image();
      img.src = src;
      img.onload = () => {
        const elem = document.createElement('canvas');
        elem.width = newX;
        elem.height = newY;
        const ctx = elem.getContext('2d');
        ctx.drawImage(img, 0, 0, newX, newY);
        const data = ctx.canvas.toDataURL();
        res(data);
      }
      img.onerror = error => rej(error);
    })
  }

  public compressImageSirina(src, newX) {
    return new Promise((res, rej) => {
      const img = new Image();
      img.src = src;
      img.onload = () => {
        const elem = document.createElement('canvas');
        
        var odnos = newX / img.width
        console.log(odnos)
        elem.width = newX;
        elem.height = img.height * odnos;
        const ctx = elem.getContext('2d');
        ctx.drawImage(img, 0, 0, newX, elem.height);
        const data = ctx.canvas.toDataURL();
        res(data);
      }
      img.onerror = error => rej(error);
    })
  }

  public uploadPhotos(apartmentId: number, slike: Set<Blob>){
    let url: string;
    url = this.apartmentForRentUrl + "/images/" + apartmentId;

    const headerDict = {
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      'Authorization': 'Bearer ' + localStorage.getItem('jwt')
    };
    
    const requestOptions = {                                                                                                                                                                                 
      headers: new HttpHeaders(headerDict), 
    };

    var photos: SlikeSetByte;
    photos = new SlikeSetByte();
    photos.slike = Array.from(slike);

    return this.http.post<any>(url, photos, requestOptions);
  }


}