import { Component, OnInit } from '@angular/core';
import { UserCredential } from '../models/userCredential.model';
import { UserCredentialService } from '../userCredential.service';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {
  userCredential: UserCredential = new UserCredential();

  constructor(private userCredentialService: UserCredentialService, private cookieService: CookieService) { 

  }

  ngOnInit() {
    
  }

  logout(): void {
    console.log(this.userCredential);
    this.userCredentialService.logout(this.userCredential)
      .subscribe( data => {
        if (data !== null) {
          this.userCredential.id = 0;
          this.userCredential.loginStatus = false;
          this.userCredential.username = "Anonymous";
          this.userCredential.type = "Unknown";

          // Checking & Saving User Id as a browser cookie
          if (this.cookieService.check('FRSLogged-InUserId')) {
            console.log("Deleting the cookie...");
            this.cookieService.delete('FRSLogged-InUserId');
          }  
          console.log("Does use id exist in a cookie: ", this.cookieService.check('FRSLogged-InUserId'));

          // Checking & Saving User Type as a browser cookie
          if (this.cookieService.check('FRSLogged-InUserType')) {
            console.log("Deleting the cookie...");
            this.cookieService.delete('FRSLogged-InUserType');
          }  
          console.log("Does user type exist in a cookie: ", this.cookieService.check('FRSLogged-InUserType'));

        } else {
          alert("User id not found");
        }
        console.log("The returned object from Spring server is: " + this.userCredential.id);
        console.log("The returned object from Spring server is: " + this.userCredential.username);
        console.log("The returned object from Spring server is: " + this.userCredential.type);
        console.log("The returned object from Spring server is: " + this.userCredential.loginStatus);
      });
  }
}
