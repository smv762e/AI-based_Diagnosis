import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CreateSolicitudComponent } from './create-solicitud/create-solicitud.component';
import { SolicitudComponent } from './solicitud/solicitud.component';
import { RobotListComponent } from './robots/robots.component';


const routes: Routes = [
  { path: '', component: SolicitudComponent },
  { path: 'request', component: SolicitudComponent },
  { path: 'create', component: CreateSolicitudComponent },
  {path: 'request/:id', component: CreateSolicitudComponent},
  { path: 'robot', component: RobotListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
