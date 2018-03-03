import { Component, OnInit } from '@angular/core';
import { UserService } from "../../../services/user/user.service";
import { User } from "../../../models/user";
import { Router } from "@angular/router";
import { ToastrService } from "ngx-toastr";

@Component({
  selector: 'app-user-create',
  templateUrl: './user-create.component.html',
  styleUrls: ['./user-create.component.css']
})
export class UserCreateComponent implements OnInit {

  submitted: boolean;
  rePassword: string;
  user: User = { id: null, lastName: null,
    firstName: null, username: null,
    password: null, email: null,
    userRank: null, orders: null };

  constructor(private userService: UserService, private router: Router,
              private toaster: ToastrService) { }

  ngOnInit() {
    this.submitted = false;
  }

  createUser(): void {
    this.submitted = true;
    this.userService.createUser(this.user)
      .subscribe(response => {
          this.user = response;
          this.toaster.success('User successfully created.', 'Success');
          this.router.navigate(['/users']);
        },
        error => {
          if (error.status === 401) {
            this.toaster.error('Session expired', 'Error');
          } else {
            this.toaster.error('Error creating user. Please try again.', 'Error');
          }
        });
  }
}
