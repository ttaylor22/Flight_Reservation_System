import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Reservation } from './models/reservation.model';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})

export class ReservationService {

  constructor(private http:HttpClient) {}

  private userUrl = 'http://localhost:8080/api/r/reservation';

  public createReservation(reservation) {
    console.log(reservation);
    return this.http.post<Reservation>(this.userUrl, reservation);
  }

  public getReservation(id) {
    return this.http.get<Reservation>(this.userUrl + "/" + id);
  }
}
