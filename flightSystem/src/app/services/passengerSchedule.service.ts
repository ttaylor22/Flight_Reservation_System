import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { PassengerSchedule } from '../models/passengerSchedule.model';

const httpOptions = {
   headers: new HttpHeaders({'Content-Type': 'application/json'})
 };

 @Injectable({
   providedIn: 'root'
})

export class PassengerScheduleService {
   constructor(private http:HttpClient) { }

   private userUrl = 'http://localhost:8080/api/passengerSchedule';

   public getPassengerSchedules() {
       return this.http.get<PassengerSchedule[]>(this.userUrl + "/getAll");
   }

   public getPassengerSchedule(passengerSchedule) {
       return this.http.get(this.userUrl + "/get/" + passengerSchedule.id);
   }

   public deletePassengerSchedule(passengerSchedule) {
      return this.http.delete(this.userUrl + "/delete/" + passengerSchedule.id);
   }

   public createPassengerSchedule(passengerSchedule) {
      return this.http.post(this.userUrl + "/add/" + passengerSchedule.id, passengerSchedule);
   }

   public updatePassengerSchedule(passengerSchedule) {
      return this.http.put(this.userUrl + "/update/" + passengerSchedule.id, passengerSchedule);
   }
}
