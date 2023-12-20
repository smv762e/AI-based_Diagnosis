import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { RequestService } from '../services/request.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Request } from '../request';
import { Location } from '@angular/common';

@Component({
  selector: 'app-create-solicitud',
  templateUrl: './create-solicitud.component.html',
  styleUrls: ['./create-solicitud.component.css']
})
export class CreateSolicitudComponent {

  request: Request = new Request();
  create: boolean = true;
  requestId: number = 0;

  constructor(private requestService: RequestService,
    private snackbar: MatSnackBar,
    private router: Router,
    private route: ActivatedRoute,
    private _location: Location) { }

  ngOnInit(): void {
    if (this.route.snapshot.paramMap.has('id')) {
      this.requestId = Number(this.route.snapshot.paramMap.get('id'));
      this.create = false;
    }

    if (!this.create) {
      this.requestService.getRequest(this.requestId).subscribe({
        next: (data: any) => {
          this.request = <Request>data;
        },
        error: (e: any) => {
          this.snackbar.open('Error communicating with the server', '', {
            duration: 3000
          });
        }
      });
    }
  }

  back() {
    this._location.back();
  }

  onSubmit(request: Request) {
    if (this.create) {
      this.requestService.createRequest(this.request).subscribe({
        next: (any) => {
          this.router.navigateByUrl('/request');
          this.snackbar.open('Solicitud created ', '', {
            duration: 3000
          });
        },
        error: (e: any) => {
          this.snackbar.open('Error creating the solicitud: ' + e.error, '', {
            duration: 3000
          });
        }
      });
    } else {
      this.requestService.updateRequest(this.request).subscribe({
        next: (any) => {
          this.router.navigateByUrl('/request');
          this.snackbar.open('Solicitud updated ', '', {
            duration: 3000
          });
        },
        error: (e: any) => {
          this.snackbar.open('Error updating the solicitud: ' + e.error, '', {
            duration: 3000
          });
        }
      });
    }
  }
}
