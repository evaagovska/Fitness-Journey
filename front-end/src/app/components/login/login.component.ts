import {Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';
import {Router} from '@angular/router';
import {UserLogin} from 'src/app/model/UserLogin';
import {AuthService} from 'src/app/services/auth.config';
import {UserService} from 'src/app/services/user.service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    user = new UserLogin()
    isLoggedIn = false;
    loginError = false;
    errorMessage = '';

    constructor(private authService: AuthService, private router: Router, private userService: UserService) {}

    ngOnInit(): void {}

    login(form: NgForm): void {


        this.authService.login(this.user.username, this.user.password).subscribe({
            next: response => {
                this.userService.saveUser(response)
                this.isLoggedIn = true
                this.errorMessage = ""
                this.loginError = false
                window.location.href = "/"
            }, error: error => {
                this.errorMessage = "Incorrect username or password";
                this.loginError = true;
                this.isLoggedIn = false;
            }
        });
    }

}


  
