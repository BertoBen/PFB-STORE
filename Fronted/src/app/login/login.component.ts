import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  loginForm: FormGroup;
  errorMessage: string = '';

  constructor(
    private authService: AuthService,
    private router: Router,
    private formBuilder: FormBuilder
  ) {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  get email(): FormControl {
    return this.loginForm.get('email') as FormControl;
  }

  get password(): FormControl {
    return this.loginForm.get('password') as FormControl;
  }

  login() {
    if (this.loginForm.invalid) {
      return;
    }

    this.authService.login(this.email.value, this.password.value).subscribe(
      response => {
        console.log('Inicio de sesión exitoso');
        localStorage.setItem('user', this.email.value);

        this.router.navigateByUrl('/', { state: { fromLogin: true } });
      },
      error => {
        console.error('Error al iniciar sesión', error);
        if (error.status === 401) {
          this.errorMessage = 'El usuario o la contraseña son erróneos';
        } else {
          this.errorMessage = 'Ocurrió un error al iniciar sesión';
        }
      }
    );
  }
}
