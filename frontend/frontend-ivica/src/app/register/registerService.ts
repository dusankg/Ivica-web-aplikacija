
import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import { JwtAutenticationRequest } from '../model/JwtAuthenticationRequest';
import { UserRequest } from '../model/UserRequest';
import { UserRequestCompany } from '../model/UserRequestCompany';

@Injectable()
export class RegisterService {
  private readonly authURL: string;

  constructor(private http: HttpClient) {
    this.authURL = 'http://localhost:8080/auth/';
  }



  public signUp(userRequest: UserRequest){
    return this.http.post<any>(this.authURL + "signup", userRequest);
  }

  public signUpCompany(userRequest: UserRequestCompany){
    return this.http.post<any>(this.authURL + "signupAgency", userRequest);
  }


}