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

  isLogin(){
    if(JSON.parse(localStorage.getItem('userInfo')) != null){
      this.isButtonVisible = false;
      return this.isButtonVisible;
    }
    else{
      return true;
    }
  }

  logout(){

    localStorage.setItem('userInfo', null);
    if(JSON.parse(localStorage.getItem('userInfo')) != null){
      this.isButtonVisible = false;
      return this.isButtonVisible;
    }
    else{
      return true;
    }

  }
}
