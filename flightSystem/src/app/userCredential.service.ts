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

   private userUrl = 'http://localhost:8080/api/userCredentials/';

   public getUserCredentials() {
      return this.http.get<UserCredential[]>(this.userUrl);
   }

   public getUserCredential(userCredential) {
      return this.http.get(this.userUrl + "/userCredential/" + userCredential.userCredentialId);
   }

   public deleteUserCredential(userCredential) {
      return this.http.delete(this.userUrl + "/deleteUserCredential/" + userCredential.userCredentialId);
   }

   public createUserCredential(userCredential) {
      return this.http.post<UserCredential>(this.userUrl + "/addUserCredential", userCredential);
   }
}