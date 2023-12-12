import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import {MatSnackBar, MatSnackBarModule} from '@angular/material/snack-bar'; 
import { ConfirmDialogComponent } from './confirm-dialog/confirm-dialog.component';
import { MatDialog } from '@angular/material/dialog';



@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrl: './request.component.css'
})
export class RequestComponent implements OnInit {
  displayedColumns =['id','drugs','view','delete'];
  accounts: JSON[]=[];
  elements={};
  dataSource= new MatTableDataSource(this.accounts);

  //Crear RequestService
  constructor(private requestService: RequestService,
    private snackbar: MatSnackBar,
    public dialog:MatDialog){}
  ngOnInit(): void{
    this.updateData();
  }


}
