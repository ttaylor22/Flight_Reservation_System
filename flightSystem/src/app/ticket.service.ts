import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Ticket } from './models/ticket.model';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  constructor(private http:HttpClient) {}

  private userUrl = 'http://localhost:8080/ticket';
	//private userUrl = '/api';

  public getTickets() {
    return this.http.get<Ticket[]>(this.userUrl + "/getAll");
  }

  public getTicket(ticket) {
    return this.http.get(this.userUrl + "/get/" + ticket.id);
  }

  public deleteTicket(ticket) {
    return this.http.delete(this.userUrl + "/delete/"+ ticket.id);
  }

  public updateTicket(ticket) {
    return this.http.put(this.userUrl + "/update/"+ ticket.id, ticket);
  }

  public createTicket(ticket) {
    return this.http.post<Ticket>(this.userUrl+"/addTicket", ticket);
  }
}
