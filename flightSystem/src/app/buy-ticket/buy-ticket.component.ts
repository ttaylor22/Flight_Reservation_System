import { Component, OnInit } from '@angular/core';
import { LoginComponent } from '../login/login.component';

import { CookieService } from 'ngx-cookie-service';
import { TicketService } from '../ticket.service';
import { UserProfile } from '../models/userProfile.model';

import { Ticket} from'../models/ticket.model';
@Component({
  selector: 'app-buy-ticket',
  templateUrl: './buy-ticket.component.html',
  styleUrls: ['./buy-ticket.component.css']
})
export class BuyTicketComponent implements OnInit {

  users: UserProfile;
  ticket: Ticket = new Ticket();
  constructor( private cookieService: CookieService, private ticketService: TicketService) { }

  ngOnInit() {
    console.log(this.cookieService.get('FRSLogged-InUserId'));


  }
/*
  getUserProfile(user : UserProfile ) : void {

    let id = +this.cookieService.get('FRSLogged-InUserId');
    this.userService.getUserProfile(user, id).subscribe(data => {
      this.users = data;
    });
  }
  */

  buyTicket(ticket: Ticket){
    this.ticketService.createTicket(this.ticket).subscribe(data => {
      this.ticket = data;
    })
  }



}
