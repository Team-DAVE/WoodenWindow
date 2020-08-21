import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatSliderModule } from '@angular/material/slider';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatSidenavModule } from '@angular/material/sidenav';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { FooterComponent } from './components/footer/footer.component';
import { UserHomepageComponent } from './components/user-homepage/user-homepage.component';
import { NewsfeedComponent } from './components/user-homepage/newsfeed/newsfeed.component';

import { UserService } from './services/user.service';
import { ProfileService } from './services/profile.service';
import { UpdateNameComponent } from './components/user-homepage/update-name/update-name.component';
import { UpdateAddressComponent } from './components/user-homepage/update-address/update-address.component';
import { UpdatePasswordComponent } from './components/user-homepage/update-password/update-password.component';
import { NewProfileComponent } from './components/user-homepage/new-profile/new-profile.component';
import { UserProfileComponent } from './components/user-homepage/user-profile/user-profile.component';
import { NewBusinessComponent } from './components/user-homepage/new-business/new-business.component';
import { BusinessComponent } from './components/user-homepage/business/business.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    FooterComponent,
    UserHomepageComponent,
    NewsfeedComponent,
    UpdateNameComponent,
    UpdateAddressComponent,
    UpdatePasswordComponent,
    NewProfileComponent,
    UserProfileComponent,
    NewBusinessComponent,
    BusinessComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatSliderModule,
    MatToolbarModule,
    AppRoutingModule,
    MatIconModule,
    MatSidenavModule
  ],
  providers: [UserService, ProfileService],
  bootstrap: [AppComponent]
})
export class AppModule { }
