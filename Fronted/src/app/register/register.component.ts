import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
  name: string = '';
  lastname: string = '';
  username: string = '';
  email: string = '';
  password: string = '';
  confirmPassword: string = '';
  phoneNumber: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  register() {
    if (this.password !== this.confirmPassword) {
      console.error('Passwords do not match');
      return;
    }

    const user = {
      name: this.name,
      lastname: this.lastname,
      username: this.email,
      email: this.email,
      password: this.password,
      phonenumber: this.phoneNumber
    };

    this.authService.register(user).subscribe(response => {
      console.log('Registration successful', response);
      this.router.navigate(['/login']);

    }, error => {
      console.error('Error registering user', error);
    });
  }
}
