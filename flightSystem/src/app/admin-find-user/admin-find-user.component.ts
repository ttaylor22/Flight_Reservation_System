import { Component, OnInit } from '@angular/core';
import { UserProfileService } from '../userProfile.service';
import { Router } from '@angular/router';
import { UserProfile } from '../models/userProfile.model';

@Component({
  selector: 'app-admin-find-user',
  templateUrl: './admin-find-user.component.html',
  styleUrls: ['./admin-find-user.component.css']
})
export class AdminFindUserComponent implements OnInit {

  userProfiles: UserProfile[];

  constructor(private router: Router, private userProfileService: UserProfileService) { }

  ngOnInit() {
    this.userProfileService.getUserProfiles().subscribe(data => {
      this.userProfiles = data;
    })
  }
}
