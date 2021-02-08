
import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import { JwtAutenticationRequest } from '../model/JwtAuthenticationRequest';

@Injectable()
export class LoginService {
  private readonly authURL: string;
  private readonly whoAmIURL: string;

  constructor(private http: HttpClient) {
    this.authURL = 'http://localhost:8080/auth/';
    this.whoAmIURL = 'http://localhost:8080/api/whoami';
  }

  public whoAmI(): Observable<any> {
    const headerDict = {
        'Content-Type': 'application/json',
        'Accept': 'application/json',
        'Authorization': 'Bearer ' + localStorage.getItem('jwt')
      };
      
      const requestOptions = {                                                                                                                                                                                 
        headers: new HttpHeaders(headerDict), 
      };

    return this.http.get<any>(this.whoAmIURL, requestOptions);
  }

  public login(request: JwtAutenticationRequest){
    return this.http.post<any>(this.authURL + "login", request);
  }

}