import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import {MatSnackBar, MatSnackBarModule} from '@angular/material/snack-bar'; 
import { MatDialog } from '@angular/material/dialog';
import { RequestService } from '../services/request.service';
import { ConfirmDialogComponent } from '../confirm-dialog/confirm-dialog.component';




@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrl: './request.component.css'
})
export class RequestComponent implements OnInit {
  displayedColumns =['id','drugs','view','delete'];
  requests: JSON[]=[];
  elements={};
  dataSource= new MatTableDataSource(this.requests);

  
  constructor(private requestService: RequestService,
    private snackbar: MatSnackBar,
    public dialog:MatDialog){}
  ngOnInit(): void{
    this.updateData();
  }

  updateData(){
    this.requestService.getRequests().subscribe({
      next:(request :JSON[]) =>{
        console.log(request);
        this.requests=request;
        this.dataSource.data=this.requests;
      },
      error: (e: any) =>{
        this.snackbar.open('Error getting the request '+e.error, '', {
          duration: 3000

    });
  },
  complete: () => console.log('done'),
});
}
delete(id: number){
  this.requestService.deleteRequest(id).subscribe({
    next: () => {
      this.updateData();
    },
    error: (e: any) => {
      this.snackbar.open('Error deleting the request '+e.error, '', {
        duration: 3000
      });
    },
    complete: () => console.log('done'),
  });
}



}
