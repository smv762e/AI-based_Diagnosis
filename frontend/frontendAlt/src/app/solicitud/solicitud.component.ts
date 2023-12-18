import { Component, OnInit } from '@angular/core';
import { RequestService } from '../services/request.service';
import { MatTableDataSource } from '@angular/material/table';
import {MatSnackBar, MatSnackBarModule} from '@angular/material/snack-bar'; 
import { ConfirmDialogComponent } from '../confirm-dialog/confirm-dialog.component';
import { MatDialog } from '@angular/material/dialog';
@Component({
  selector: 'app-solicitud',
  templateUrl: './solicitud.component.html',
  styleUrls: ['./solicitud.component.css']
})
export class SolicitudComponent implements OnInit {
  displayedColumns = ['id', 'drugs', 'id_ruta','view','delete'];
  solicitudes: JSON[] =[];
  element = {};
  dataSource = new MatTableDataSource(this.solicitudes);

  constructor(private solicitudService: RequestService,
    private snackbar: MatSnackBar,
    public dialog: MatDialog) { }
    
  ngOnInit(): void {  
    this.updateData();
  }

  updateData(){
    this.solicitudService.getRequests().subscribe({
      next: (solicitudes: JSON[]) => {
        console.log(solicitudes);
        this.solicitudes = solicitudes;
        this.dataSource.data=this.solicitudes;
      },
      error: (e: any) => {
        this.snackbar.open('Error getting the solicitudes '+e.error, '', {
          duration: 3000
        });
      },
      complete: () => console.log('done'),
    });
  }
  delete(id: number){
    this.solicitudService.deleteRequest(id).subscribe({
      next: () => {
        this.updateData();
      },
      error: (e: any) => {
        this.snackbar.open('Error deleting the solicitud '+e.error, '', {
          duration: 3000
        });
      },
      complete: () => console.log('done'),
    });
  }

  confirmDeletion(id: number) {
    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      width: '250px',
      data: { title: 'solicitud ' + id }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.delete(id);
      }
    });
  }

}
