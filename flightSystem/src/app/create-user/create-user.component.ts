import { Component, OnInit } from '@angular/core';
import { UserProfile } from '../models/userProfile.model';
import { UserCredential } from '../models/userCredential.model';

import { UserCredentialService } from '../userCredential.service';
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
  credentialId   : number;
  profileId      : number;

  userProfiles : UserProfile[];

  constructor(
    private router : Router,
    private userProfileService : UserProfileService,
    private userCredentialService : UserCredentialService 
  ) { }

  
  ngOnInit() {
    this.userProfileService.getUserProfiles()
        .subscribe( data => {
          this.userProfiles = data;
        });
  }

  createUser() : void {
    //alert(this.userProfile.emailId);
    this.userCredential.username = this.userProfile.emailId;
    this.userCredential.loginStatus = false;
    this.userCredential.password = this.userCredential.password;
    this.userCredential.type = "User";
    this.userCredential.userProfile = this.userProfile;
    //this.userProfile.userCredential = this.userCredential;
/*
    this.userProfile.userCredential.username = this.userProfile.emailId;
    this.userProfile.userCredential.type = "User";
    this.userProfile.userCredential.loginStatus = false;
    this.userProfile.userCredential.password = this.userCredential.password;
    //this.credentialId = -1;
    
*/

    this.userCredentialService.createUserCredential(this.userCredential)
    .subscribe( data => {
      alert("User Profile And Credential created successfully.");
    });

    // this.userCredentialService.createUserCredential(this.userCredential)
    // .subscribe( data => {
    //   alert("User Credential created successfully.");
    //   alert(data.id);
    //   this.credentialId = data.id;
    //   this.userCredential.id = this.credentialId;
    //   //this.updateUserCredentials();
    // });
  }

  // updateUserCredentials() : void {
  //   this.userCredentialService.updateUserProfileCredential(this.userProfile,this.userCredential)
  //   .subscribe( data => {
  //     this.userCredential.id = this.credentialId;
  //     this.userProfile.id = this.profileId;
  //     alert("Credential and Profile Created!");
  //   })
  // }

  deleteUser(userProfile) : void {
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
