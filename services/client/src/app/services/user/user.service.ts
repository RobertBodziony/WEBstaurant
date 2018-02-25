import { Injectable } from '@angular/core';
import { User } from '../../models/user';
import { USERS } from '../../mock-users';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { MessageService } from '../message/message.service';
import { HttpClient, HttpHeaders} from "@angular/common/http";


@Injectable()
export class UserService {

  private usersUrl = 'users';

  constructor(
    private messageService: MessageService,
    private http: HttpClient
    ) { }

  getUsers(): Observable<any> {
    this.messageService.add('UserService: fetched users');
    return this.http.get('//localhost:8010/users');
  }

  getUser(id: string): Observable<any> {
    this.messageService.add(`UserService: fetched user id=${id}`);
    return this.http.get('//localhost:8010/users/'+id);
  }

  private log(message: string) {
    this.messageService.add('UserService: ' + message);
  }
}
