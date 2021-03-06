import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import {UserProfile} from 'src/app/models/userProfile.model';
import { UserCredential } from 'src/app/models/userCredential.model';
import { Observable } from 'rxjs';
const httpOptions = {
   headers: new HttpHeaders({'Content-Type': 'application/json'})
 };


@Injectable({
  providedIn: 'root'
})
export class UserProfileService {


  constructor(private http:HttpClient) {}

  private userUrl = 'http://localhost:8080/api/user';

  public getUserProfiles() {
    return this.http.get<UserProfile[]>(this.userUrl + "/profiles");
  }

  public getUserProfile(userProfile, userId) {
     return this.http.get<UserProfile>(this.userUrl + "/profile/" + userId );//userProfile.id);
  }

  public deleteUserProfile(userProfile) {
     return this.http.delete(this.userUrl + "/profile/" + userProfile.id);
  }

  public createUserProfile(userProfile) {
     //alert("Account Successfully Created");
     return this.http.post<UserProfile>(this.userUrl + "/profile", userProfile);
  }

  public updateUserProfile(userProfile) {
      return this.http.put<UserProfile>(this.userUrl + "/profile/" + userProfile.id, userProfile);
  }

  public updateUserProfileCredential(userProfile, userCredential) {
      return this.http.put<UserProfile>(this.userUrl + "/profile/" + userProfile.id + "/user/credential/" + userCredential.id, userProfile);
  }

}
