import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Route } from '../models/route.model';
import { FlightSchedule } from '../models/flightSchedule.model'

import { Flight } from '../models/flight.model';
import { FlightService } from '../flight.service';
import { RouteService } from '../route.service';


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

  checked = false;
  trip = false;

  constructor(private router: Router, private flightService: FlightService,
    private routeService: RouteService) { }

    ngOnInit() {
      /*
      this.flightService.getFlights()
        .subscribe( data => {
          this.flights = data;
        });
        */

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
}
