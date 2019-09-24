import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Flight } from '../models/flight.model';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  constructor(private http:HttpClient) {}

  private userUrl = 'http://localhost:8080/api/flight';
	//private userUrl = '/api';

  public getFlights() {
    return this.http.get<Flight[]>(this.userUrl + "/getAll");
  }

  public getFlight(flight) {
    return this.http.get(this.userUrl + "/get/" + flight.id);
  }

  public deleteFlight(flight) {
    return this.http.delete(this.userUrl + "/delete/"+ flight.id);
  }

  public updateFlight(flight) {
    return this.http.put(this.userUrl + "/update/"+ flight.id, flight);
  }

  public createFlight(flight) {
    return this.http.post<Flight>(this.userUrl+"/addFlight", flight);
  }
}
