import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponentComponent } from './login-component/login-component.component';
import { HomePageComponent } from './home-page/home-page.component';
import { RegisterComponent } from './register/register.component';
import { ValidateAccountComponent } from './validate-account/validate-account.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';

const routes: Routes = [
  { path: 'login', component: LoginComponentComponent },
  { path: 'homePage', component: HomePageComponent },
  { path: '', component: HomePageComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'validateAccount', component: ValidateAccountComponent },
  { path: 'resetPassword', component: ResetPasswordComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
