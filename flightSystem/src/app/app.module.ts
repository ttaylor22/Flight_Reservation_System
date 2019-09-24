import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateUSerComponent } from './create-user/create-user.component';
import { FlightDetailsComponent } from './flight-details/flight-details.component';
import { ShowFlightsComponent } from './show-flights/show-flights.component';
import { AccountPageComponent } from './account-page/account-page.component';
import { HttpClientModule } from '@angular/common/http';
import { AddFlightComponent } from './add-flight/add-flight.component';
import { LoginComponent } from './login/login.component';


@NgModule({
  declarations: [
    AppComponent,
    CreateUSerComponent,
    FlightDetailsComponent,
    ShowFlightsComponent,
    AccountPageComponent,
    AddFlightComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    HttpClientModule, 
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
