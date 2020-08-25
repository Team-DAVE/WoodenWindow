import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/users';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  User:User;
  constructor() { }
  public isButtonVisible = true;

  ngOnInit(): void {
  }

  isLoggedIn(): boolean{
    if(JSON.parse(localStorage.getItem('userInfo')) != null){

      return false;
    }
    else{
      return true;
    }
  }

  logout():void{

    localStorage.setItem('userInfo', null);

  }
}
