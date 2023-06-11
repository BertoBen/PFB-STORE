import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  welcomeMessage: string = '';

  constructor(private router: Router) { }

  ngOnInit(): void {
    const username = localStorage.getItem('user');

    if (username) {
      this.welcomeMessage = 'Bienvenido al Store ' + username;
    }
  }

  isLoggedIn(): boolean {
    return localStorage.getItem('user') !== null;
  }

  login(): void {
    // Redirección al formulario de inicio de sesión
    this.router.navigate(['/login']);
  }

  register(): void {
    // Redirección al formulario de inicio de sesión
    this.router.navigate(['/register']);
  }


  logout(): void {
    // Elimina el indicador de inicio de sesión y redirige al formulario de inicio de sesión
    localStorage.removeItem('user');
    this.router.navigate(['/login']);
  }

}
