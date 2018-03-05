import { Component, OnInit } from '@angular/core';
import { User } from '../../../models/user';
import { UserService } from '../../../services/user/user.service';
import {Observable} from "rxjs/Observable";


@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: User[];

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.getUsers();
  }

  getUsers(): void {
    this.userService.getUsers()
      .subscribe(response => {
        this.users = response
      },
        error => {
          console.error("Error fetching users!");
        }
      );
  }


  deleteUser(id: string): void {
    this.userService.deleteUser(id)
      .subscribe(response => {
        this.getUsers();
        console.log(response)
      },
      error => {
        console.error("Error deleting user!");
      });
  }

}
