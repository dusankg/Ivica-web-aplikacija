import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-apartment-for-rent',
  templateUrl: './add-apartment-for-rent.component.html',
  styleUrls: ['./add-apartment-for-rent.component.css']
})
export class AddApartmentForRentComponent implements OnInit {

  public brojac: number;
  public base64Image: string;
  public base64Images: Set<string>;


  constructor() { 
    this.base64Images = new Set<string>();
  }

  ngOnInit(): void {
  }

  // SLIKE
  
  changeListener($event): void {
    this.readThis($event.target);
  }

  readThis(inputValue: any): void {
    var file: File = inputValue.files[0];
    var myReader: FileReader = new FileReader();

    myReader.onloadend = (e) => {
      this.base64Image = myReader.result as string;
      this.base64Images.add(myReader.result as string);
      //this.carDTO.images.push(myReader.result as string);
    }
    myReader.readAsDataURL(file);

  }
  removeImage(imageName: string){
    this.base64Images.delete(imageName);
  }

  // KRAJ SLIKA
}
