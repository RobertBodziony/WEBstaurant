import { Component, OnInit, Input } from '@angular/core';
import { User } from '../../../models/user';
import { ActivatedRoute, Router } from "@angular/router";
import { UserService } from "../../../services/user/user.service";
import { ToastrService } from "ngx-toastr";

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {

  @Input() user: User;
  editView: boolean;
  constructor(
    private route: ActivatedRoute,
    private userService: UserService,
    private router: Router,
    private toaster: ToastrService
  ) {}

  ngOnInit() {
    this.editView = false;
    this.getUser();
  }

  getUser(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.userService.getUser(id)
      .subscribe(user => {
        this.user = user;
      }, error => {
        if(error.status === 404){
          this.toaster.error('User not found.','Error!');
        } else {
          this.toaster.error('Something went wrong. Try again.','Error!');
        }
      })
  }

  update(): void {
    this.userService.updateUser(this.user)
      .subscribe(user => {
        this.user = user;
        this.toaster.success('User successfully updated','Success!');
      }, error => {
        if(error.status === 404){
          this.toaster.error('User not found.','Error!');
        } else {
          this.toaster.error('Something went wrong. Try again.','Error!');
        }
      })
  }

  edit(): void {
    this.editView = true;
  }

}
