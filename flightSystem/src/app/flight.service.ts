import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Flight } from './models/flight.model';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  constructor(private http:HttpClient) {}


  private userUrl = 'http://localhost:8080/api';
	//private userUrl = '/api';

  public getFlights() {
    return this.http.get<Flight[]>(this.userUrl + "/flights");
  }

  public getAdminFlights(): any{
    return this.http.get<any[]>(this.userUrl + "/displayFlights");
  }

  public getFlight(flight) {

    return this.http.get<Flight>(this.userUrl + "/flight/" + flight.id);
  }

  public getFlightId(id) {

    return this.http.get<Flight>(this.userUrl + "/flight/" + id);
  }

  public deleteFlight(id: number) {
    return this.http.delete(this.userUrl + "/flight/"+ id);

  }

  public updateFlight(flight) {
    return this.http.put(this.userUrl + "/flight/"+ flight.id, flight);
  }

  public createFlight(flight) {
    return this.http.post<Flight>(this.userUrl+"/flight", flight);

  }


}
