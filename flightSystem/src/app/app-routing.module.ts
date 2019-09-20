import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreationComponent } from './UserProfile/creation/creation.component';
import { ReadComponent } from './UserProfile/read/read.component';


const routes: Routes = [
  { path: 'CreateProfile', component: CreationComponent},
  { path: 'ReadProfile', component: ReadComponent}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
