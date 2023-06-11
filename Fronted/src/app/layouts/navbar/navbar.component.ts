import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  welcomeMessage: string = '';

  constructor(private router: Router) { }

  ngOnInit(): void {
    const username = localStorage.getItem('user');

    if (username) {
      this.welcomeMessage = 'Hola ' + username;
      // Elimina el indicador de inicio de sesión para que el mensaje de bienvenida no se muestre nuevamente al actualizar la página
      //localStorage.removeItem('username');
    }

  }

  getHeaderStyles(): any {
    return {
      'color': 'white'
    };
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
