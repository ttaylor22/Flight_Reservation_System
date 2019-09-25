import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ShowFlightsComponent } from './show-flights/show-flights.component';
import { FlightDetailsComponent } from './flight-details/flight-details.component';
import { CreateUSerComponent } from './create-user/create-user.component';
import { AccountPageComponent } from './account-page/account-page.component';
import { AddFlightComponent } from './add-flight/add-flight.component';
import { ShowAllFlightsAdminComponent} from'./show-all-flights-admin/show-all-flights-admin.component';
import { LogoutComponent } from './logout/logout.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AdminAddFlightScheduleComponent } from './admin-add-flight-schedule/admin-add-flight-schedule.component';
import { AdminAddRouteComponent } from './admin-add-route/admin-add-route.component';
import { AdminFindUserComponent } from './admin-find-user/admin-find-user.component';
import { AdminFindPassengerComponent } from './admin-find-passenger/admin-find-passenger.component';
import { ViewBookedFlightsComponent} from'./view-booked-flights/view-booked-flights.component';
import { BuyTicketComponent} from'./buy-ticket/buy-ticket.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'show-flights', component: ShowFlightsComponent},
  {path: 'flight-details', component: FlightDetailsComponent},
  {path: 'create-user', component: CreateUSerComponent},
  {path: 'account-page', component: AccountPageComponent},
  {path: 'add-flight', component: AddFlightComponent},
  {path: 'admin', component:ShowAllFlightsAdminComponent},
  {path: 'logout-page', component: LogoutComponent},
  {path: 'admin-home', component:AdminHomeComponent},
  {path: 'show-all-flights-admin', component:ShowAllFlightsAdminComponent},
  {path: 'admin-add-flight-schedule', component:AdminAddFlightScheduleComponent},
  {path: 'admin-add-route', component:AdminAddRouteComponent},
  {path: 'admin-find-user', component:AdminFindUserComponent},
  {path: 'admin-find-passenger', component:AdminFindPassengerComponent},
  {path: 'view-booked-flights', component: ViewBookedFlightsComponent},
  {path: 'enter-payment', component: BuyTicketComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  // declarations: [LogoutComponent],
  exports: [RouterModule]
})
export class AppRoutingModule { }
