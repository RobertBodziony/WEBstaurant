import { Injectable } from '@angular/core';
import { User } from '../../models/user';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {catchError} from "rxjs/operators";
import {ErrorObservable} from "rxjs/observable/ErrorObservable";

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable()
export class UserService {

  private pathSlash = '/';
  private usersUrl = 'users';
  private restApiUrl = '//localhost:8010/';

  constructor(
    private http: HttpClient
    ) { }

  getUsers(): Observable<User[]> {
    console.log('UserService - fetching all users.');
    return this.http.get<User[]>(this.restApiUrl + this.usersUrl, httpOptions);
  }

  getUser(id: string): Observable<User> {
    console.log(`UserService - fetching user with id = ${id}.`);
    return this.http.get<User>(this.restApiUrl + this.usersUrl + this.pathSlash +id, httpOptions);
  }

  createUser(user: User): Observable<User> {
    console.log(`UserService - creating user.`);
    return this.http.post<User>(this.restApiUrl + this.usersUrl, user, httpOptions);
  }

  updateUser(user: User): Observable<User> {
    console.log(`UserService - updating user with id = ${user.id}.`);
    return this.http.put<User>(this.restApiUrl + this.usersUrl, user, httpOptions);
  }

  deleteUser(id: string): Observable<any> {
    console.log(`UserService - deleting user with id = ${id}.`);
    return this.http.delete(this.restApiUrl + this.usersUrl + this.pathSlash +id, httpOptions);
  }


  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    return new ErrorObservable(
      'Something bad happened; please try again later.');
  };
}
