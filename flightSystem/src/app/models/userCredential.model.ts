import { UserProfile } from './userProfile.model';

export class UserCredential {
   id                : number;
   type              : string;
   username          : string;
   password          : string;
   loginStatus       : boolean;
   userProfile       : UserProfile;
}