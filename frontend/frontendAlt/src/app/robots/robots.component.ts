// robot-list.component.ts
import { Component, OnInit } from '@angular/core';
import { RobotService } from '../services/robot.service';
import { MatTableDataSource } from '@angular/material/table';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { ConfirmDialogComponent } from '../confirm-dialog/confirm-dialog.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-robots',
  templateUrl: './robots.component.html',
  styleUrls: ['./robots.component.css']
})
export class RobotListComponent implements OnInit {

  displayedColumns = ['id', 'nombre', 'estado', 'view', 'delete'];
  robots: any[] = []; 
  element = {};
  dataSource = new MatTableDataSource(this.robots);

  constructor(private robotService: RobotService,
    private snackbar: MatSnackBar,
    public dialog: MatDialog) { }

  ngOnInit(): void {
    this.updateData();
  }

  updateData() {
    this.robotService.getRobots().subscribe({
      next: (robots: any[]) => {
        console.log(robots);
        this.robots = robots;
        this.dataSource.data = this.robots;
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
    this.robotService.deleteRobot(id).subscribe({
      next: () => {
        this.updateData();
      },
      error: (e: any) => {
        this.snackbar.open('Error deleting the robot ' + e.error, '', {
          duration: 3000
        });
      },
      complete: () => console.log('done'),
    });
  }

  confirmDeletion(id: number) {
    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      width: '250px',
      data: { title: 'Robot ' + id }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.delete(id);
      }
    });
  }
}