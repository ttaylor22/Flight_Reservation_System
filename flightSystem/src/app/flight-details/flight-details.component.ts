import { Component, OnInit } from '@angular/core';
import { FlightService } from '../flight.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Flight } from '../models/flight.model';
import { Route } from '../models/route.model';

import { RouteService } from '../route.service';

@Component({
  selector: 'app-flight-details',
  templateUrl: './flight-details.component.html',
  styleUrls: ['./flight-details.component.css']
})
export class FlightDetailsComponent implements OnInit {

  flight : Flight;
  route  : Route;

  constructor(private router : Router, 
              private flightService : FlightService,
              private routeService  : RouteService,
              private activatedRoute : ActivatedRoute
  ) { }

  ngOnInit() {
    var idString = this.activatedRoute.snapshot.paramMap.get('id');
    var id = +idString;
    console.log(id);
  }
}
