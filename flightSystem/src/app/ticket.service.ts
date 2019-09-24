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

  private userUrl = 'http://localhost:8080/api';
	//private userUrl = '/api';

  public getTickets() {
    return this.http.get<Ticket[]>(this.userUrl + "/tickets");
  }

  public getTicket(ticket) {
    return this.http.get(this.userUrl + "/ticket/" + ticket.id);
  }

  public deleteTicket(ticket) {
    return this.http.delete(this.userUrl + "/ticket/"+ ticket.id);
  }

  public updateTicket(ticket) {
    return this.http.put(this.userUrl + "/ticket/"+ ticket.id, ticket);
  }

  public createTicket(ticket) {
    return this.http.post<Ticket>(this.userUrl+"/ticket", ticket);
  }
}
