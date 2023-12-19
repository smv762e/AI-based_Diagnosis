// request-list.component.ts
import { Component, OnInit } from '@angular/core';
import { RequestService } from '../services/request.service';
import { MatTableDataSource } from '@angular/material/table';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { ConfirmDialogComponent } from '../confirm-dialog/confirm-dialog.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-request-list',
  templateUrl: './solicitud.component.html',
  styleUrls: ['./solicitud.component.css']
})
export class RequestListComponent implements OnInit {

  displayedColumns = ['id', 'route', 'drugs', 'view', 'delete'];
  requests: any[] = [];
  element = {};
  dataSource = new MatTableDataSource(this.requests);

  constructor(private requestService: RequestService,
    private snackbar: MatSnackBar,
    public dialog: MatDialog) { }

  ngOnInit(): void {
    this.updateData();
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
}