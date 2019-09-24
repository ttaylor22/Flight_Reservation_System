import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { UserCredential } from './models/userCredential.model';

const httpOptions = {
   headers: new HttpHeaders({'Content-Type': 'application/json'})
 };
 
 @Injectable({
   providedIn: 'root'
})

export class UserCredentialService {
   constructor(private http:HttpClient) {}

   private userUrl = 'http://localhost:8080/api/user/';

   public getUserCredentials() {
      return this.http.get<UserCredential[]>(this.userUrl + "/credentials");
   }

   public getUserCredential(userCredential) {
      return this.http.get(this.userUrl + "/credential/" + userCredential.id);
   }

   public deleteUserCredential(userCredential) {
      return this.http.delete(this.userUrl + "/credential/" + userCredential.id);
   }

   public createUserCredential(userCredential) {
      return this.http.post<UserCredential>(this.userUrl + "/credential", userCredential);
   }

   public updateUserCredential(userCredential) {
      return this.http.put<UserCredential>(this.userUrl + "/credential/" + userCredential.id, userCredential);
   }
}