import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreationComponent } from './UserProfile/creation/creation.component';
import { ReadComponent } from './UserProfile/read/read.component';
import { UpdateComponent } from './UserProfile/update/update.component';
import { DeleteComponent } from './UserProfile/delete/delete.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { UserProfileService } from './Service/user-profile.service';

@NgModule({
  declarations: [
    AppComponent,
    CreationComponent,
    ReadComponent,
    UpdateComponent,
    DeleteComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UserProfileService],
  bootstrap: [AppComponent]
})
export class AppModule { }
