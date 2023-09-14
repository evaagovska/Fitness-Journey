import {Component, OnInit} from '@angular/core';
import {AuthService} from 'src/app/services/auth.config';
import {UserService} from 'src/app/services/user.service';
import {CookieService} from 'ngx-cookie-service';

@Component({
    selector: 'app-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

    isLoggedIn = false;


    constructor(private userService: UserService, private authService: AuthService,
                private cookieService: CookieService) {
    }

    ngOnInit(): void {
        this.isLoggedIn = this.userService.isLoggedIn()
    }


    logout() {
        this.authService.logout().subscribe({
            next: response => {
                this.userService.clean()

                window.location.href = "/log-in"
            },
            error: error => {
                console.log(error)

            }
        })
        this.cookieService.delete('bezkoder')
    }
}
