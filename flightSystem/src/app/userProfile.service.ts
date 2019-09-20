import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import {UserProfile} from 'src/app/models/userProfile.model';
import { Observable } from 'rxjs';
const httpOptions = {
   headers: new HttpHeaders({'Content-Type': 'application/json'})
 };


@Injectable({
  providedIn: 'root'
})
export class UserProfileService {


  constructor(private http:HttpClient) {}

  private userUrl = 'http://localhost:8080/profiles';

  public findAll(): Observable<any> {
    return this.http.get(this.userUrl);
  }

  public getUserProfile() {
     return this.http.get<UserProfile[]>(this.userUrl);
  }

  public deleteUserProfile(userProfile) {
     return this.http.delete(this.userUrl + "/deleteUserProfile/" + userProfile.userProfileId);
  }

  public createUserProfile(userProfile) {
     return this.http.post<UserProfile>(this.userUrl + "/addUserProfile", userProfile);
  }

}