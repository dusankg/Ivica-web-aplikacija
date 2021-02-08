import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { APP_BASE_HREF } from '@angular/common';
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import {MatSelectModule} from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {MatDialogModule} from '@angular/material/dialog';
import {MatMenuModule} from '@angular/material/menu';
import { RouterModule } from '@angular/router';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatListModule } from '@angular/material/list';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';
import { LoginComponentComponent } from './login-component/login-component.component';
import { LoginService } from './login-component/login-service';
import { HomePageComponent } from './home-page/home-page.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { RegisterComponent } from './register/register.component';
import { ValidateAccountComponent } from './validate-account/validate-account.component';
import { RegisterService } from './register/registerService';
import { ValidateAccountService } from './validate-account/validateAccount-service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponentComponent,
    HomePageComponent,
    ResetPasswordComponent,
    RegisterComponent,
    ValidateAccountComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    MatSelectModule,
    MatFormFieldModule,
    MatInputModule,
    MatDialogModule,
    MatMenuModule,
    MatSnackBarModule,
    MatListModule,
    MatPaginatorModule,
    MatButtonModule,
    MatDividerModule,
    HttpClientModule
  ],
  providers: [ LoginService, RegisterService, ValidateAccountService, { provide: APP_BASE_HREF, useValue: '/' }],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
