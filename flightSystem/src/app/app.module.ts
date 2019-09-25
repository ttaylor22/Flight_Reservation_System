import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatRadioModule } from '@angular/material/radio';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule} from '@angular/material/card';
import { MatNativeDateModule } from '@angular/material/';
import { MatTableModule } from '@angular/material/table';
import { MatMenuModule } from '@angular/material/menu';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateUSerComponent } from './create-user/create-user.component';
import { FlightDetailsComponent } from './flight-details/flight-details.component';
import { ShowFlightsComponent } from './show-flights/show-flights.component';
import { AccountPageComponent } from './account-page/account-page.component';
import { HttpClientModule } from '@angular/common/http';
import { AddFlightComponent } from './add-flight/add-flight.component';
import { LoginComponent } from './login/login.component';
import { ShowAllFlightsAdminComponent } from './show-all-flights-admin/show-all-flights-admin.component';


import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AdminAddFlightScheduleComponent } from './admin-add-flight-schedule/admin-add-flight-schedule.component';
import { AdminAddRouteComponent } from './admin-add-route/admin-add-route.component';
import { AdminFindUserComponent } from './admin-find-user/admin-find-user.component';
import { AdminFindPassengerComponent } from './admin-find-passenger/admin-find-passenger.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateUSerComponent,
    FlightDetailsComponent,
    ShowFlightsComponent,
    AccountPageComponent,
    AddFlightComponent,
    LoginComponent,

    ShowAllFlightsAdminComponent,

    AdminHomeComponent,

    AdminAddRouteComponent,

    AdminAddFlightScheduleComponent,

    AdminFindUserComponent,

    AdminFindPassengerComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatInputModule,
    MatFormFieldModule,
    MatCheckboxModule,
    MatRadioModule,
    MatButtonModule,
    MatCardModule,
    MatNativeDateModule,
    MatTableModule,
    MatMenuModule
  ],
  exports: [FormsModule, ReactiveFormsModule, MatTableModule, MatMenuModule],
  providers: [],
  bootstrap: [AppComponent],
})




export class AppModule { }
