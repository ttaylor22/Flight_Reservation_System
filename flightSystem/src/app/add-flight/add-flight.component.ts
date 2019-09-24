import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Flight } from '../models/flight.model';
import { Route } from '../models/route.model';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent  implements OnInit {

  flight: Flight = new Flight();
  //route: Route = new Route();
  constructor(private router: Router, private flightService: FlightService) { }

  ngOnInit() { }

  createFlight(): void {
    this.flightService.createFlight(this.flight)
    .subscribe( data => {
      alert("Flight created successfully.");
    });
  };

}
