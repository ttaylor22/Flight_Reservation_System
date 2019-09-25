import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Route } from './models/route.model';


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class RouteService {

  constructor(private http:HttpClient) {}


  private userUrl = 'http://localhost:8080/api';

	//private userUrl = '/api';

  public getRoutes() {
    return this.http.get<Route[]>(this.userUrl + "/routes");
  }

  public getRoute(route) {
    return this.http.get(this.userUrl + "/route/" + route.id);
  }

  public deleteRoute(route) {
    return this.http.delete(this.userUrl + "/route/"+ route.id);
  }

  public updateRoute(route) {
    return this.http.put(this.userUrl + "/route/"+ route.id, route);
  }

  public createRoute(route) {
    return this.http.post<Route>(this.userUrl+"/route", route);
  }

  public displayFlights(route, flightSchedule){
    console.log(flightSchedule.scheduleDay);
    return this.http.get<any>(this.userUrl +"/displayFlights/" +  route.source + "/" + route.destination+"/"+ flightSchedule.scheduleDay);
  }

  public displayAllFlights(){
    return this.http.get<any>(this.userUrl + "/getAllFlights")
  }


}
