import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CreateSolicitudComponent } from './create-solicitud/create-solicitud.component';
import { RequestListComponent } from './solicitud/solicitud.component';
import { RobotListComponent } from './robots/robots.component';
import { HomeComponent } from './home/home.component';
import {LoginComponent} from './login/login.component';
import {AuthGuard} from './auth.guard';
import {HeaderComponent} from './header/header.component';



const routes: Routes = [
  { path: 'login', component: LoginComponent },
  {
    path: 'header',
    component: HeaderComponent,
    canActivate: [AuthGuard] // Proteger la ruta con el guard de autenticación
  },
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
