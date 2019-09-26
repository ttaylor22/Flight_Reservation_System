import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Route } from '../models/route.model';
import { FlightSchedule } from '../models/flightSchedule.model'

import { Flight } from '../models/flight.model';
import { FlightService } from '../flight.service';
import { RouteService } from '../route.service';

import { CookieService } from 'ngx-cookie-service';
import { Reservation } from '../models/reservation.model';
import { ReservationService } from '../reservation.service';

@Component({
  selector: 'app-show-flights',
  templateUrl: './show-flights.component.html',
  styleUrls: ['./show-flights.component.css']
})
export class ShowFlightsComponent implements OnInit {

  flights: Flight[];
  routes: any[];
  route: Route = new Route();
  flightSchedule: FlightSchedule = new FlightSchedule();

  //isRoundTrip = false;
  checked = false;
  trip = false;
  isPressed = false;

   flightId: number;
    flightScheduleId: number;
    routeId: number;

    flightT: Flight;
    flightScheduleT: FlightSchedule;
    routeT: Route;
    reservation: Reservation = new Reservation();

  constructor(private router: Router,
              private flightService: FlightService,
              private routeService: RouteService,
              private cookieService: CookieService,
              private reservationService: ReservationService
              ) { }

    ngOnInit() {
      /*
      this.flightService.getFlights()
        .subscribe( data => {
          this.flights = data;
        });
        */
       this.routeService.displayAllFlights().subscribe(data => {
        this.routes = data;
      });

    };
/*
    deleteFlight(flight: Flight): void {
      this.flightService.deleteFlight(flight)
        .subscribe( data => {
          this.flights = this.flights.filter(u => u !== flight);
        })
    };
*/
    getFlight(flight : Flight) : void {
      this.flightService.getFlight(flight);
    }

    displayFlights(route: Route, flightSchedule: FlightSchedule): void{
      this.routeService.displayFlights(this.route, this.flightSchedule).subscribe(data => {
          this.routes = data;
      });
    }


    bookFlights(routes: any){
      console.log(routes);
    }

    confirm(route: Route)
    {
      console.log(route);
      this.reservation.flightId = route[8];
      this.reservation.flightScheduleId = route[9];
      this.reservation.routeId = route[10];
      this.reservation.userProfileId = +this.cookieService.get('FRSLogged-InUserId');
      this.reservation.dateTime = "2019-05-05";
      this.reservationService.createReservation(this.reservation)
      .subscribe( data => {
        alert("Reservation created successfully.");
      });



    }


}
