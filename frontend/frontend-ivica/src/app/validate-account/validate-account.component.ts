import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { VerificationAcountDTO } from '../model/VerificationAcountDTO';
import { ValidateAccountService } from './validateAccount-service';

@Component({
  selector: 'app-validate-account',
  templateUrl: './validate-account.component.html',
  styleUrls: ['./validate-account.component.css']
})
export class ValidateAccountComponent implements OnInit {

  public validationUsername: string;
  public validationPassword: string;
  public validationCode: number;
  constructor(private router: Router, private validationService: ValidateAccountService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.validationCode = Number(this.route.snapshot.paramMap.get("code"))
  }

  // TODO Slanje validacije na back
  finishRegistration(){

    var verificationDTO : VerificationAcountDTO = new VerificationAcountDTO
    verificationDTO.username = this.validationUsername;
    verificationDTO.password = this.validationPassword;
    verificationDTO.validationCode = this.validationCode;

    this.validationService.verificate(verificationDTO).subscribe(
      response => {
        alert("Mozete se ulogovati sada");
        this.router.navigate(["login"]);
      }, err => {
        alert("Validacija nije prosla kako treba, pokusajte ponovo");
      }
    );
  }

}
