// login.component.ts

import { Component } from '@angular/core';
import { AdminService } from '../services/admin.service'; // Asegúrate de que la ruta sea correcta
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  // Define una instancia del formulario
  loginForm: FormGroup;


  // Defina las propiedades user, password, y selectedRole
  user: string | undefined;
  password: string | undefined;
  selectedRole: string | undefined;

  isLogged: boolean = false;

  // Constructor para inicializar el FormBuilder
  constructor(private fb: FormBuilder) {
    // Inicializa el formulario en el constructor
    this.loginForm = this.fb.group({
      user: ['', Validators.required],
      password: ['', Validators.required],
      selectedRole: ['Médico', Validators.required],
    });
  }

  // Modifica el método login para usar el formulario
  login() {
    // Accede a los valores del formulario
    const { user, password, selectedRole } = this.loginForm.value;

    // Resto del código del método login
  }
}
