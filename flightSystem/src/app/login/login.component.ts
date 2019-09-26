import { Component, OnInit } from '@angular/core';
import { UserCredential } from '../models/userCredential.model';
import { UserCredentialService } from '../userCredential.service';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userCredential: UserCredential = new UserCredential();

  constructor(private router: Router, private userCredentialService: UserCredentialService, private cookieService: CookieService) { 

  }

  ngOnInit() {
    this.userCredential.id = 0;
    this.userCredential.loginStatus = false;
    this.userCredential.username = "Anonymous";
    this.userCredential.type = "Unknown";
  }

  login(): void {
    console.log(this.userCredential);
    this.userCredentialService.authenticate(this.userCredential)
      .subscribe( data => {
        if (data !== null) {
          this.userCredential = data;
        } 
        console.log("The returned object from Spring server is: " + this.userCredential.id);
        console.log("The returned object from Spring server is: " + this.userCredential.username);
        console.log("The returned object from Spring server is: " + this.userCredential.type);
        console.log("The returned object from Spring server is: " + this.userCredential.loginStatus);

        if (this.userCredential.id === 0)   alert("User Not Found");
        else {
          alert("Logged-in user's id is: " + this.userCredential.id);
          
          // Checking & Saving User Id as a browser cookie
          if (this.cookieService.check('FRSLogged-InUserId')) {
            this.cookieService.delete('FRSLogged-InUserId');
          }  
          this.cookieService.set('FRSLogged-InUserId', this.userCredential.id.toString(), 1);
          console.log("Saved user id in a cookie is ", this.cookieService.get('FRSLogged-InUserId'));

          // Checking & Saving User Type as a browser cookie
          if (this.cookieService.check('FRSLogged-InUserType')) {
            this.cookieService.delete('FRSLogged-InUserType');
          }  
          this.cookieService.set('FRSLogged-InUserType', this.userCredential.type, 1);
          console.log("Saved user type in a cookie is ", this.cookieService.get('FRSLogged-InUserType'));
        
          // redirect the user to '/show-flights' page
          this.router.navigate(['/show-flights']);
        }  
      });
  }
}