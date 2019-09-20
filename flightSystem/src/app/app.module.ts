import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreationComponent } from './Account/creation/creation.component';
import { ReadComponent } from './Account/read/read.component';
import { UpdateComponent } from './Account/update/update.component';
import { DeleteComponent } from './Account/delete/delete.component';

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
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
