import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RequestComponent } from './request/request.component';
import { HeaderComponent } from './header/header.component';

const routes: Routes = [
  {path:'', component: HeaderComponent},
  {path: 'request', component: RequestComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
