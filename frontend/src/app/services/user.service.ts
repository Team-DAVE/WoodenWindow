import { Injectable } from '@angular/core';

import { User } from '../models/users';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  users: User[];
  userUrl = 'http://localhost:8080/WoodenWindow_war_exploded/api/user';

  constructor(private httpClient: HttpClient) {
    this.users = [
      {
        userId: 1,
        password: 'password',
        email: 'testOne@host.com',
        firstName: 'Test',
        lastName: 'One',
      },
      {
        userId: 2,
        password: 'password',
        email: 'testTwo@host.com',
        firstName: 'Test',
        lastName: 'Two',
      },
      {
        userId: 3,
        password: 'password',
        email: 'testThree@host.com',
        firstName: 'Test',
        lastName: 'Three',
      },
      {
        userId: 4,
        password: 'password',
        email: 'testFour@host.com',
        firstName: 'Test',
        lastName: 'Four',
      }
    ];
   }

  getUserById(userId: number): User {
    return this.users.find( user => user.userId === userId);
  }

  getUser(): Observable<string> {
    console.log('service called');
    const httpHead = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        // 'Access-Control-Allow-Orgin': '*'
      })
    };
    console.log(httpHead);
    return this.httpClient.get<string>(this.userUrl, httpHead);
  }

  addUser(userForm): Observable<string> {
    console.log(userForm);
    const httpHead = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Orgin': '*'
      })
    };
    return this.httpClient.post<string>(this.userUrl, userForm, httpHead);
  }
}
