import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateUSerComponent } from './create-user/create-user.component';
import { FlightDetailsComponent } from './flight-details/flight-details.component';
import { ShowFlightsComponent } from './show-flights/show-flights.component';
import { SigninComponent } from './signin/signin.component';
import { AccountPageComponent } from './account-page/account-page.component';
import {AlertModule} from 'ngx-bootstrap';


@NgModule({
  declarations: [
    AppComponent,
    CreateUSerComponent,
    FlightDetailsComponent,
    ShowFlightsComponent,
    SigninComponent,
    AccountPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
