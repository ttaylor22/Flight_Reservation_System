import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ShowFlightsComponent } from './show-flights/show-flights.component';
import { FlightDetailsComponent } from './flight-details/flight-details.component';
import { CreateUSerComponent } from './create-user/create-user.component';
import { AccountPageComponent } from './account-page/account-page.component';
import { AddFlightComponent } from './add-flight/add-flight.component';


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'show-flights', component: ShowFlightsComponent},
  {path: 'flight-details/:id', component: FlightDetailsComponent},
  {path: 'create-user', component: CreateUSerComponent},
  {path: 'account-page', component: AccountPageComponent}, 
  {path: 'add-flight', component: AddFlightComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
