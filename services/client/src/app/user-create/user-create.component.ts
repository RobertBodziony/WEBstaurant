import { Component, OnInit } from '@angular/core';
import { UserService } from "../services/user/user.service";
import {User} from "../models/user";

@Component({
  selector: 'app-user-create',
  templateUrl: './user-create.component.html',
  styleUrls: ['./user-create.component.css']
})
export class UserCreateComponent implements OnInit {

  user: User;
  firstName = '';
  lastName = '';
  username = '';
  email = '';
  password = '';

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  createUser($form): void {
    if($form.invalid){
      return;
    }
    this.user.firstName = this.firstName;
    this.user.lastName = this.lastName;
    this.user.username = this.username;
    this.user.email = this.email;
    this.user.password = this.password;
    console.log(this.user);
  }
}
