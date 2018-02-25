import { Component, OnInit, Input } from '@angular/core';
import { User } from '../models/user';
import { ActivatedRoute } from "@angular/router";
import { Location } from "@angular/common";
import { UserService } from "../services/user/user.service";
import {routerNgProbeToken} from "@angular/router/src/router_module";

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {

  @Input() user: User;

  constructor(
    private route: ActivatedRoute,
    private userService: UserService,
    private location: Location
  ) {}

  ngOnInit() {
    this.getUser();
  }

  getUser(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.userService.getUser(id)
      .subscribe(user => this.user = user)
  }

  goBack(): void {
    this.location.back();
  }
}
