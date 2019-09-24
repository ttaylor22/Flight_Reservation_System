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


  private userUrl = 'http://localhost:8080/route';

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

  public displayFlights(route){
    console.log(route.source + ' ' + route.destination);
    return this.http.get<any>(this.userUrl +"/displayFlights/" +  route.source + "/" + route.destination);
  }


}
