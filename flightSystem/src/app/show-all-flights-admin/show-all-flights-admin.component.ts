import { Component, OnInit } from '@angular/core';

import { FlightService } from '../flight.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-show-all-flights-admin',
  templateUrl: './show-all-flights-admin.component.html',
  styleUrls: ['./show-all-flights-admin.component.css']
})
export class ShowAllFlightsAdminComponent implements OnInit {

  constructor(private router: Router, private flightService: FlightService) { }

  ngOnInit() {
  }

}
