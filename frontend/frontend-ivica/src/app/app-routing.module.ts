import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponentComponent } from './login-component/login-component.component';
import { HomePageComponent } from './home-page/home-page.component';
import { RegisterComponent } from './register/register.component';
import { ValidateAccountComponent } from './validate-account/validate-account.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { TermsAndConditionsComponent } from './terms-and-conditions/terms-and-conditions.component';
import { RegisterCompanyComponent } from './register-company/register-company.component';
import { ListaApartmanaComponent} from './lista-apartmana/lista-apartmana.component';
import { AddApartmentForRentComponent} from './add-apartment-for-rent/add-apartment-for-rent.component';
import { ApartmentDetailsComponent } from './apartment-details/apartment-details.component';
const routes: Routes = [
  { path: 'login', component: LoginComponentComponent },
  { path: 'homePage', component: HomePageComponent },
  { path: '', component: HomePageComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'validateAccount/:code', component: ValidateAccountComponent },
  { path: 'resetPassword', component: ResetPasswordComponent },
  { path: 'termsAndConditions', component: TermsAndConditionsComponent },
  { path: 'registerCompany', component: RegisterCompanyComponent },
  { path: 'listaApartmana', component: ListaApartmanaComponent },
  { path: 'addApartmentForRent', component: AddApartmentForRentComponent },
  { path: 'apartmentDetails/:apartmentId', component: ApartmentDetailsComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
