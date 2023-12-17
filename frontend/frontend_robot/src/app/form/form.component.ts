import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RequestService } from '../services/request.service';


@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {
  requestForm: FormGroup;
  isEditing = false;
  selectedRequestId: number;

  constructor(private formBuilder: FormBuilder, private requestService: RequestService) { }

  ngOnInit(): void {
    this.initializeForm();
  }

  initializeForm(): void {
    this.requestForm = this.formBuilder.group({
      drugs: ['', Validators.required],
      // Agrega otros campos según sea necesario
    });
  }

  onSubmit(): void {
    const formData = this.requestForm.value;

    if (this.isEditing) {
      // Actualizar solicitud existente
      this.requestService.updateRequest({ id: this.selectedRequestId, ...formData }).subscribe(
        () => {
          // Lógica después de la actualización
          this.resetForm();
        },
        (error) => {
          console.error('Error updating request', error);
        }
      );
    } else {
      // Crear nueva solicitud
      this.requestService.createRequest(formData).subscribe(
        () => {
          // Lógica después de la creación
          this.resetForm();
        },
        (error) => {
          console.error('Error creating request', error);
        }
      );
    }
  }

  resetForm(): void {
    this.requestForm.reset();
    this.isEditing = false;
    this.selectedRequestId = null;
  }

  editRequest(requestId: number): void {
    // Obtener los datos de la solicitud para editar
    this.requestService.getRequest(requestId).subscribe(
      (data) => {
        this.requestForm.patchValue(data);
        this.isEditing = true;
        this.selectedRequestId = requestId;
      },
      (error) => {
        console.error('Error fetching request for editing', error);
      }
    );
  }
}
