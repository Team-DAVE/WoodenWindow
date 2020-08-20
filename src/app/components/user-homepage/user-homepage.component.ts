import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { User } from 'src/app/models/users';
import { Profile } from 'src/app/models/profile';
import { UserService } from '../../services/user.service';
import { ProfileService } from 'src/app/services/profile.service';

@Component({
  selector: 'app-user-homepage',
  templateUrl: './user-homepage.component.html',
  styleUrls: ['./user-homepage.component.css']
})
export class UserHomepageComponent implements OnInit {
  userSideNavabarSelection = 'newsStream';
  user: User;
  currentUserId: number;
  userProfiles: Profile[];

  constructor(private route: ActivatedRoute, private userService: UserService, private profileService: ProfileService) { }

  ngOnInit(): void {
    this.currentUserId = parseInt(this.route.snapshot.paramMap.get('userId'), 10);
    this.user = this.userService.getUserById(this.currentUserId);
    this.userProfiles = this.profileService.getUserProfiles(this.currentUserId);
  }

  setUserSideNavbarSelection(newSelection: string): void {
    this.userSideNavabarSelection = newSelection;
  }

}
