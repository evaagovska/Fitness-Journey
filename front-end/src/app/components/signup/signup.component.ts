import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from 'src/app/model/User';
import { AuthService } from 'src/app/services/auth.config';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  user = new User()
  repeatedPassword: string | undefined
  passwordNotMatched: boolean = false;
  checked = false
  constructor(private authService: AuthService) { }

  signup(form: NgForm): void {

    if (this.user.password != this.repeatedPassword) {
      this.passwordNotMatched = true;
      return;
    }

    this.authService.register(this.user).subscribe({
      next: response => {
        window.location.href = "/log-in"
      }, error: error => {
        console.log('error')
      }
    });


  }
}


