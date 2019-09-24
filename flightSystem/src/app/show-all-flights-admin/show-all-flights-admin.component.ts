import { Component, OnInit } from '@angular/core';

import { FlightService } from '../flight.service';
import { Router } from '@angular/router';

import { Route } from '../models/route.model';
import { FlightSchedule } from '../models/flightSchedule.model'
import { Flight } from '../models/flight.model';

@Component({
  selector: 'app-show-all-flights-admin',
  templateUrl: './show-all-flights-admin.component.html',
  styleUrls: ['./show-all-flights-admin.component.css']
})
export class ShowAllFlightsAdminComponent implements OnInit {

  flights: any[];

  constructor(private router: Router, private flightService: FlightService) { }

  ngOnInit() {
    //this.reloadData();

    this.flightService.getAdminFlights().subscribe(data => {
      this.flights = data;
    });

  }

  reloadData() {
    this.flights = this.flightService.getAdminFlights();
  }

  deleteFlight(id: number): void {
    this.flightService.deleteFlight(id)
      .subscribe( data => {
        //this.flights = this.flights.filter(u => u !== flight);
        this.reloadData();

      });
  };






}
