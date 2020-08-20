import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { User } from 'src/app/models/users';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-user-homepage',
  templateUrl: './user-homepage.component.html',
  styleUrls: ['./user-homepage.component.css']
})
export class UserHomepageComponent implements OnInit {
  userSideNavabarSelection = 'newsStream';
  user: User;
  currentUserId: number;

  constructor(private route: ActivatedRoute, private userService: UserService) { }

  ngOnInit(): void {
    this.currentUserId = parseInt(this.route.snapshot.paramMap.get('userId'), 10);
    this.user = this.userService.getUserById(this.currentUserId);
  }

  setUserSideNavbarSelection(newSelection: string): void {
    this.userSideNavabarSelection = newSelection;
  }

}
