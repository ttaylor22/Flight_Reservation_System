import { Component, OnInit, Input } from '@angular/core';
import { Reservation } from '../models/reservation.model';

//import { ShowFlightsComponent} from '../show-flights/show-flights.component';
import { ReservationService } from '../reservation.service';
import { FlightService } from '../flight.service';
import { FlightScheduleService} from '../flightSchedule.service';
import { RouteService} from '../route.service';

import { CookieService } from 'ngx-cookie-service';
import { Flight } from '../models/flight.model';
import { FlightSchedule } from '../models/flightSchedule.model';
import { Route } from '../models/route.model';

@Component({
  selector: 'app-account-page',
  templateUrl: './account-page.component.html',
  styleUrls: ['./account-page.component.css']
})
export class AccountPageComponent implements OnInit {

  reservation: Reservation = new Reservation();
  flight: Flight = new Flight();
  flightSchedule: FlightSchedule = new FlightSchedule();
  route: Route  = new Route();

  constructor( private reservationService: ReservationService,  private cookieService: CookieService,
               private flightService: FlightService,
               private routeService: RouteService,
               private flightScheduleService: FlightScheduleService,) { }

  id: number = +this.cookieService.get('FRSLogged-InUserId');

  ngOnInit() {
    this.reservationService.getReservationId(this.id)
      .subscribe( data => {
        this.reservation = data;
        console.log(this.reservation);
        this.displayReservation();
        this.displayFlightScheduleId();
        this.displayRoutesId();
      });


  }

  displayReservation(){
     // tslint:disable-next-line: align
     this.flightService.getFlightId(this.reservation.flightId)
     .subscribe( data => {
       this.flight = data;
       console.log(this.flight);
     });
  }

  displayFlightScheduleId(){
    // tslint:disable-next-line: align
    this.flightScheduleService.getFlightScheduleId(this.reservation.flightScheduleId)
    .subscribe( data => {
      this.flightSchedule = data;
      console.log(this.flightSchedule);
    });
  }

  displayRoutesId(){
    // tslint:disable-next-line: align
    this.routeService.getRouteId(this.reservation.routeId)
    .subscribe( data => {
      this.route = data;
      console.log(this.route);
    });
  }





}
