import { Injectable } from '@angular/core';

import { User } from '../models/users';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  users: User[];

  constructor() {
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
}
