// header.component.ts

import { Component } from '@angular/core';
import { AdminService } from '../services/admin.service'; // Asegúrate de que la ruta sea correcta

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  constructor(private adminService: AdminService) {}

  // Métodos necesarios para el enlace en el template
  isAdminAuthenticated(): boolean {
    return this.adminService.isAuthenticatedUser();
  }

  getSelectedRole(): string {
    return this.adminService.getSelectedRole();
  }

  logout(): void {
    this.adminService.setAuthenticationStatus(false);
    // Lógica adicional de logout si es necesario
  }
}
