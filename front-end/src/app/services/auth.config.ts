import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/User';
import { UserService } from './user.service';

const PATH_AUTH = 'http://localhost:8080/api/';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  })
};
const USER_KEY = 'auth-user';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient, private userService: UserService) { }

  login(username: string, password: string): Observable<any> {

    return this.http.post(
        `${PATH_AUTH}login`, {username, password}, httpOptions);
  }


  logout(): Observable<any> {
    this.userService.clean()
    return this.http.post(`${PATH_AUTH}logout`, httpOptions);
  }

  register(user: User): Observable<any> {
    return this.http.post(`${PATH_AUTH}users/add`, user);
  }


}




