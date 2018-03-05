import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';



import { AppComponent } from './app.component';
import { UsersComponent } from './components/users/user-list/users.component';
import { FormsModule } from "@angular/forms";
import { UserDetailComponent } from './components/users/user-detail/user-detail.component';
import { UserService } from "./services/user/user.service";
import { AppRoutingModule } from './/app-routing.module';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { UserCreateComponent } from './components/users/user-create/user-create.component';
import { OrderComponent } from './components/orders/order/order.component';
import { OrderListComponent } from './components/orders/order-list/order-list.component';
import { OrderDetailsComponent } from './components/orders/order-details/order-details.component';
import { OrderCreateComponent } from './components/orders/order-create/order-create.component';
import { ProductListComponent } from './components/products/product-list/product-list.component';
import { ProductDetailsComponent } from './components/products/product-details/product-details.component';
import { ProductCreateComponent } from './components/products/product-create/product-create.component';
import { IngredientListComponent } from './components/ingredients/ingredient-list/ingredient-list.component';
import { IngredientDetailsComponent } from './components/ingredients/ingredient-details/ingredient-details.component';
import { IngredientCreateComponent } from './components/ingredients/ingredient-create/ingredient-create.component';
import { AuthComponent } from './components/authentiaction/auth/auth.component';


@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    UserDetailComponent,
    DashboardComponent,
    UserCreateComponent,
    OrderComponent,
    OrderListComponent,
    OrderDetailsComponent,
    OrderCreateComponent,
    ProductListComponent,
    ProductDetailsComponent,
    ProductCreateComponent,
    IngredientListComponent,
    IngredientDetailsComponent,
    IngredientCreateComponent,
    AuthComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot()
  ],
  providers: [
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
