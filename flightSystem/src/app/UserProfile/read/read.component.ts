import { Component, OnInit } from '@angular/core';
import { UserProfile } from 'src/app/Model/user-profile';
import { UserProfileService } from 'src/app/Service/user-profile.service';

@Component({
  selector: 'app-read',
  templateUrl: './read.component.html',
  styleUrls: ['./read.component.css']
})
export class ReadComponent implements OnInit {

  profiles: Array<any>;

  constructor(private userProfileService: UserProfileService) { }

  ngOnInit() {
    this.userProfileService.findAll().subscribe(data => {
      this.profiles = data;
    });
  }

}
