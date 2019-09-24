import { Component, OnInit } from '@angular/core';
import { UserProfile } from '../models/userProfile.model';
import { UserCredential } from '../models/userCredential.model';

import { UserCredentialService } from '../services/userCredential.service';
import { UserProfileService } from '../userProfile.service';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';


@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUSerComponent implements OnInit {

  userProfile    : UserProfile    = new UserProfile();
  userCredential : UserCredential = new UserCredential();
  //credentialId   : number;

  userProfiles : UserProfile[];

  constructor(
    private router : Router,
    private userProfileService : UserProfileService,
    private userCredentialService : UserCredentialService
  ) { }


  ngOnInit() {
    /*
    this.userProfileService.getUserProfiles()
        .subscribe( data => {
          this.userProfiles = data;
        });*/
  }

  createUser() : void {
    //alert(this.userProfile.emailId);
    this.userCredential.username = this.userProfile.emailId;
    this.userCredential.type = "User";
    //alert("WAH");

    this.userCredentialService.createUserCredential(this.userCredential)
    .subscribe( data => {
        //this.credentialId = data.id;
        //alert("In createUserCredential : " + this.credentialId);
    });

    //alert("This is an alert");
    //alert("In createUser : " + this.credentialId);
    //this.userProfile.userCredentialId = this.userCredential.id;
    //alert(this.userCredential.password);
    /*
    this.userCredentialService.getUserCredentialId(this.userCredential)
    .subscribe( data => {
      alert(this.userCredential);
    });
    */
   //this.userProfile.userCredentialId = this.credentialId;
   //alert(this.userProfile.userCredentialId);

   //this.userProfile.userCredentialId = this.credentialId;
    this.userProfileService.createUserProfile(this.userProfile)
    .subscribe( data => {
      alert("User Profile created successfully.");
    });
  }

  deleteUser(userProfile) : void {
    alert(userProfile.userCredentialId);
    this.userProfileService.deleteUserProfile(userProfile.id).subscribe( data => {

    });
    this.userCredentialService.deleteUserCredential(userProfile.userCredentialId).subscribe( data => {

    });
  }

  updateUser(userProfile) : void {
    this.userProfileService.updateUserProfile(userProfile.id).subscribe( data => {

    });
  }
}
