import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserHomepageComponent } from './components/user-homepage/user-homepage.component';
import { HomeComponent } from './components/home/home.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'user/:userId', component: UserHomepageComponent},
  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
