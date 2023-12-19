import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CreateSolicitudComponent } from './create-solicitud/create-solicitud.component';
import { RequestListComponent } from './solicitud/solicitud.component';
import { RobotListComponent } from './robots/robots.component';
import { HomeComponent } from './home/home.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'requests', component: RequestListComponent },
  { path: 'create', component: CreateSolicitudComponent },
  {path: 'request/:id', component: CreateSolicitudComponent},
  { path: 'robot', component: RobotListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
