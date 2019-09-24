import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { ReservationHasFlight } from '../models/reservationHasFlight.model';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class ReservationHasFlightService {

  constructor(private http:HttpClient) {}

  private userUrl = 'http://localhost:8080/api/reservationHasFlight';
	//private userUrl = '/api';

  public getReservationHasFlights() {
    return this.http.get<ReservationHasFlight[]>(this.userUrl + "/getAll");
  }

  public getReservationHasFlight(reservationHasFlight) {
    return this.http.get(this.userUrl + "/get/" + reservationHasFlight.id);
  }

  public deleteReservationHasFlight(reservationHasFlight) {
    return this.http.delete(this.userUrl + "/delete/"+ reservationHasFlight.id);
  }

  public updateReservationHasFlight(reservationHasFlight) {
    return this.http.put(this.userUrl + "/update/"+ reservationHasFlight.id, reservationHasFlight);
  }

  public createReservationHasFlight(reservationHasFlight) {
    return this.http.post<ReservationHasFlight>(this.userUrl+"/addReservationHasFlight", reservationHasFlight);
  }
}
