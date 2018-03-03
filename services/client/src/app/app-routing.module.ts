import { NgModule } from '@angular/core';
import { Routes,RouterModule } from "@angular/router";
import { UsersComponent } from "./components/users/user-list/users.component";
import { DashboardComponent } from "./components/dashboard/dashboard.component";
import { UserDetailComponent } from "./components/users/user-detail/user-detail.component";
import { UserCreateComponent } from "./components/users/user-create/user-create.component";

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'users', component: UsersComponent },
  { path: 'users/:id', component: UserDetailComponent },
  { path: 'create/user', component: UserCreateComponent },
];

@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ]
})

export class AppRoutingModule {}
