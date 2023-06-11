import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AuthService {
    // Asume que tienes un servidor Spring ejecutándose en el localhost en el puerto 8080
    private apiUrl = 'http://localhost:8080';

    constructor(private http: HttpClient) { }

   /* register(email: string, password: string): Observable<any> {
        const url = `${this.apiUrl}/store/register`;
        return this.http.post(url, { email, password });
    }*/

    register(user: any): Observable<any> {
      const url = `${this.apiUrl}/store/register`;
      return this.http.post(url, user);
    }
  

    login(email: string, password: string): Observable<any> {
        const url = `${this.apiUrl}/store/login`;
        return this.http.post(url, { email, password });
    }

    
}
