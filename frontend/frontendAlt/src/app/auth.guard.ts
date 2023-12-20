import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AdminService } from './services/admin.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private authService: AdminService, private router: Router) {}

  canActivate(): boolean {
    if (this.authService.isAuthenticatedUser()) {
      return true; // Permite el acceso si el usuario está autenticado
    } else {
      this.router.navigate(['/home']); // Redirige al componente de inicio de sesión si no está autenticado
      return false;
    }
  }
}
