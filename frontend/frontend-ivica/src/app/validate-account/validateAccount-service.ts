
import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import { JwtAutenticationRequest } from '../model/JwtAuthenticationRequest';
import { UserRequest } from '../model/UserRequest';
import { ValidateAccountComponent } from './validate-account.component';
import { VerificationAcountDTO } from '../model/VerificationAcountDTO';

@Injectable()
export class ValidateAccountService {
  private readonly authURL: string;

  constructor(private http: HttpClient) {
    this.authURL = 'http://localhost:8080/auth/';
  }



  public verificate(validateRequest: VerificationAcountDTO){
    return this.http.post<any>(this.authURL + "verificate", validateRequest);
  }


}