/* import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

   baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) { }
    url=this.baseUrl+"/admins";
  login(user: string, password: string): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/login`, { user, password });
  }
}
 */

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Admin } from '../admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  baseUrl = environment.baseUrl;
  private isAuthenticated: boolean = false;
  private selectedRole: string = '';

  constructor(private http: HttpClient) {}

  login(user: string, password: string): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/login`, { user, password });
  }

  // Método para establecer el estado de autenticación
  setAuthenticationStatus(status: boolean) {
    this.isAuthenticated = status;
  }

  // Método para verificar si el usuario está autenticado
  isAuthenticatedUser(): boolean {
    return this.isAuthenticated;
  }

  // Método para establecer el rol seleccionado
  setSelectedRole(role: string) {
    this.selectedRole = role;
  }

  // Método para obtener el rol seleccionado
  getSelectedRole(): string {
    return this.selectedRole;
  }
  
}