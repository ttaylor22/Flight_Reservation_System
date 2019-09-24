import { Component, OnInit } from '@angular/core';
import { FlightService } from '../flight.service';
import { Router } from '@angular/router';
import { Flight } from '../models/flight.model';

@Component({
  selector: 'app-flight-details',
  templateUrl: './flight-details.component.html',
  styleUrls: ['./flight-details.component.css']
})
export class FlightDetailsComponent implements OnInit {

  flight : Flight;

  constructor(private router : Router, private flightService : FlightService) { }

  ngOnInit() {
    this.flightService.getFlight(this.flight).subscribe(data => {
    });
  }

}
