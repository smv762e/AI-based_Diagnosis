// solicitud.component.ts
import { Component, OnInit } from '@angular/core';
import { RequestService } from '../services/request.service';
import { MatTableDataSource } from '@angular/material/table';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { ConfirmDialogComponent } from '../confirm-dialog/confirm-dialog.component';
import { MatDialog } from '@angular/material/dialog';
import { RobotService } from '../services/robot.service'; 


@Component({
  selector: 'app-request-list',
  templateUrl: './solicitud.component.html',
  styleUrls: ['./solicitud.component.css']
})
export class RequestListComponent implements OnInit {
  [x: string]: any;

  displayedColumns = ['id', 'route', 'drugs', 'robot', 'accepted', 'accept', 'view', 'delete'];
  requests: any[] = [];
  element = {};
  robots: any[] = [];  // Agregamos la lista de robots
  dataSource = new MatTableDataSource(this.requests);

  constructor(private requestService: RequestService,
    private snackbar: MatSnackBar,
    public dialog: MatDialog,
    private robotService: RobotService  ) { }

  ngOnInit(): void {
    this.updateData();
    this.loadRobots();  // Cargamos la lista de robots al inicializar
  }

  updateData() {
    this.requestService.getRequests().subscribe({
      next: (requests: any[]) => {
        console.log(requests);
        this.requests = requests;
        this.dataSource.data = this.requests;
      },
      error: (e: any) => {
        this.snackbar.open('Error getting the solicitudes ' + e.error, '', {
          duration: 3000
        });
      },
      complete: () => console.log('done'),
    });
  }

  loadRobots() {
    this.robotService.getRobots().subscribe({
      next: (robots: any[]) => {
        console.log(robots);
        // Filtrar los robots con estado true
        this.robots = robots.filter(robot => robot.estado === true);
      },
      error: (e: any) => {
        this.snackbar.open('Error getting the robots ' + e.error, '', {
          duration: 3000
        });
      },
      complete: () => console.log('done'),
    });
  }

  delete(id: number) {
    this.requestService.deleteRequest(id).subscribe({
      next: () => {
        this.updateData();
      },
      error: (e: any) => {
        this.snackbar.open('Error deleting the solicitud ' + e.error, '', {
          duration: 3000
        });
      },
      complete: () => console.log('done'),
    });
  }

  confirmDeletion(id: number) {
    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      width: '250px',
      data: { title: 'Solicitud ' + id }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.delete(id);
      }
    });
  }
  onRobotSelected(event: any, element: any) {
    const selectedRobotId = event.value;
    // Asignar el robot a la solicitud
    element.robotId = selectedRobotId;
  }
  
  acceptRequest(requestId: number) {
    // Obtén el ID del carro asociado desde el elemento actual
    const robotId = this.requests.find(request => request.id === requestId)?.robotId;
  
    if (robotId) {
      // Llama al servicio para aceptar la solicitud y actualizar el estado del carro
      this.requestService.acceptRequest(requestId, robotId).subscribe({
        next: () => {
          // Realiza cualquier acción adicional después de aceptar la solicitud
          this.updateData();
        },
        error: (e: any) => {
          this.snackbar.open('Error accepting the request ' + e.error, '', {
            duration: 3000
          });
        },
        complete: () => console.log('done'),
      });
    }
  }
  
}
