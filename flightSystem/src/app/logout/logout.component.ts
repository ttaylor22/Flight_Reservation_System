import { Component, OnInit } from '@angular/core';
import { UserCredential } from '../models/userCredential.model';
import { UserCredentialService } from '../userCredential.service';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})

export class LogoutComponent implements OnInit {
  userCredential: UserCredential = new UserCredential();

  constructor(private router: Router, private userCredentialService: UserCredentialService, private cookieService: CookieService) { 

  }

  ngOnInit() {
    
  }

  getStoredUserId(): number {
    if (this.cookieService.check('FRSLogged-InUserId')) {
      return parseInt(this.cookieService.get('FRSLogged-InUserId'));
    } else return 0; 
  }

  logout(): void {
    console.log(this.userCredential);
    this.userCredentialService.logout( this.getStoredUserId(), this.userCredential)
      .subscribe( data => {
        if (data !== null) {
          this.userCredential = data;
          // Checking & Deleting User Id from a browser cookie
          if (this.cookieService.check('FRSLogged-InUserId')) {
            console.log("Deleting the cookie...");
            this.cookieService.delete('FRSLogged-InUserId');
          }  
          console.log("Does use id exist in a cookie: ", this.cookieService.check('FRSLogged-InUserId'));

          // Checking & Deleting User Type from a browser cookie
          if (this.cookieService.check('FRSLogged-InUserType')) {
            console.log("Deleting the cookie...");
            this.cookieService.delete('FRSLogged-InUserType');
          }  
          console.log("Does user type exist in a cookie: ", this.cookieService.check('FRSLogged-InUserType'));
        } else {
          alert("User not found");
        }

        // redirect the user to '/show-flights' page
        this.router.navigate(['/login']);

        console.log("The returned object from Spring server is: " + this.userCredential.id);
        console.log("The returned object from Spring server is: " + this.userCredential.username);
        console.log("The returned object from Spring server is: " + this.userCredential.type);
        console.log("The returned object from Spring server is: " + this.userCredential.loginStatus);
      });
  }
}
