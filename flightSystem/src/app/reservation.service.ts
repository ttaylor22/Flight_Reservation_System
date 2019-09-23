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

  private userUrl = 'http://localhost:8080/reservation';
	//private userUrl = '/api';

  public getReservations() {
    return this.http.get<Reservation[]>(this.userUrl + "/getAll");
  }

  public getReservation(reservation) {
    return this.http.get(this.userUrl + "/get/" + reservation.id);
  }

  public deleteReservation(reservation) {
    return this.http.delete(this.userUrl + "/delete/"+ reservation.id);
  }

  public updateReservation(reservation) {
    return this.http.put(this.userUrl + "/update/"+ reservation.id, reservation);
  }

  public createReservation(reservation) {
    return this.http.post<Reservation>(this.userUrl+"/addReservation", reservation);
  }
}