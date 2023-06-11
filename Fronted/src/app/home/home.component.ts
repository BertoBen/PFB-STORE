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
      // Elimina el indicador de inicio de sesión para que el mensaje de bienvenida no se muestre nuevamente al actualizar la página
      //localStorage.removeItem('username');
    }
  }

  isLoggedIn(): boolean {
    return localStorage.getItem('user') !== null;
  }

  login(): void {
    // Implementa la lógica de redirección al formulario de inicio de sesión
    this.router.navigate(['/login']);
  }

  register(): void {
    // Implementa la lógica de redirección al formulario de inicio de sesión
    this.router.navigate(['/register']);
  }


  logout(): void {
    // Elimina el indicador de inicio de sesión y redirige al formulario de inicio de sesión
    localStorage.removeItem('user');
    this.router.navigate(['/login']);
  }

}
