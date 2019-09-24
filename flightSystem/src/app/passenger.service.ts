import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Passenger } from './models/passenger.model';

const httpOptions = {
   headers: new HttpHeaders({'Content-Type': 'application/json'})
 };
 
 @Injectable({
   providedIn: 'root'
})

export class PassengerService {
   constructor(private http:HttpClient) { }

   private userUrl = 'http://localhost:8080/api';

   public getPassengers() {
      return this.http.get<Passenger[]>(this.userUrl + "/passengers");
   }

   public getPassenger(passenger) {
      return this.http.get<Passenger[]>(this.userUrl + "/passenger/" + passenger.passengerId);
   }

   public deletePassenger(passenger) {
      return this.http.delete(this.userUrl + '/passenger/' + passenger.passengerId);
   }

   public createPassenger(passenger) {
      return this.http.post(this.userUrl + "/passenger", passenger.passengerId);
   }
   
}