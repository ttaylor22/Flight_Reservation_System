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

  private userUrl = 'http://localhost:8080/userProfile';

  public findAll(): Observable<any> {
    return this.http.get(this.userUrl + "/getAll");
  }

  public getUserProfile(userProfile) {
     return this.http.get<UserProfile[]>(this.userUrl + "/get/" + userProfile.id);
  }

  public deleteUserProfile(userProfile) {
     return this.http.delete(this.userUrl + "/delete/" + userProfile.id);
  }

  public createUserProfile(userProfile) {
     return this.http.post<UserProfile>(this.userUrl + "/add", userProfile);
  }

  public updateUserProfile(userProfile) {
      return this.http.put<UserProfile>(this.userUrl + "/update/" + userProfile.id, userProfile);
  }

}