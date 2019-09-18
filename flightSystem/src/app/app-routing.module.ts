import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SigninComponent } from './signin/signin.component';
import { ShowFlightsComponent } from './show-flights/show-flights.component';
import { FlightDetailsComponent } from './flight-details/flight-details.component';
import { CreateUSerComponent } from './create-user/create-user.component';
import { AccountPageComponent } from './account-page/account-page.component';


const routes: Routes = [
  {path: 'signin', component: SigninComponent},
  {path: 'show-flights', component: ShowFlightsComponent},
  {path: 'flight-details', component: FlightDetailsComponent},
  {path: 'create-user', component: CreateUSerComponent},
  {path: 'account-page', component: AccountPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
