import { Component } from '@angular/core';
import { FormComponent  } from './form.component';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent {
  requests: any[] = [];
  newRequest: any = {};
  selectedRequest: any = {};

  constructor(private formService: FormComponent) { }

  ngOnInit(): void {
    this.loadRequests();
  }

  loadRequests(): void {
    this.formService.getRequests().subscribe(
      (data) => {
        this.requests = data;
      },
      (error) => {
        console.error('Error fetching requests', error);
      }
    );
  }

  createRequest(): void {
    this.formService.createRequest(this.newRequest).subscribe(
      (data) => {
        this.loadRequests();
        this.newRequest = {}; // Limpiar el formulario después de la creación
      },
      (error) => {
        console.error('Error creating request', error);
      }
    );
  }

  editRequest(request: any): void {
    this.selectedRequest = { ...request }; // Crear una copia para no modificar directamente el objeto
  }

  updateRequest(): void {
    // Lógica para actualizar la solicitud seleccionada
    // Puedes usar this.selectedRequest.id y this.selectedRequest.drugs
    // Luego, llama al servicio para realizar la actualización
  }

  deleteRequest(requestId: number): void {
    // Lógica para eliminar la solicitud con el ID proporcionado
    // Luego, llama al servicio para realizar la eliminación
  }

}