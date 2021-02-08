import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponentComponent } from './login-component/login-component.component';
import { HomePageComponent } from './home-page/home-page.component';

const routes: Routes = [
  { path: 'login', component: LoginComponentComponent },
  { path: 'homePage', component: HomePageComponent },
  { path: '', component: HomePageComponent }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
