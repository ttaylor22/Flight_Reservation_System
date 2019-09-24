import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Flight } from './models/flight.model';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})

export class FlightScheduleService {
   constructor(private http:HttpClient) {}

   private userUrl = 'http://localhost:8080/api/flight';

   public getFlightSchedules() {
   return this.http.get<Flight[]>(this.userUrl + "/schedules");
   }

   public getFlightSchedule(flightSchedule) {
   return this.http.get(this.userUrl + "/schedule/" + flightSchedule.id);
   }

   public deleteFlightSchedule(flightSchedule) {
   return this.http.delete(this.userUrl + "/schedule/"+ flightSchedule.id);
   }

   public createFlightSchedule(flightSchedule) {
   return this.http.post<Flight>(this.userUrl+"/schedule", flightSchedule);
   }

   public updateFlightSchedule(flightSchedule) {
     return this.http.post<Flight>(this.userUrl + "/schedule/" + flightSchedule.id, flightSchedule);
   }
}