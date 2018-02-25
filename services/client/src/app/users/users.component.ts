import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { USERS } from '../mock-users';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users = USERS;

  selectedUser: User;

  constructor() { }

  ngOnInit() {
    // INITIALIZATION LOGIC HERE
  }

  onSelect(user: User): void {
    this.selectedUser = user;
  }

}
