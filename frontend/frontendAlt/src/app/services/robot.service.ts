// robot.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RobotService {
  private baseUrl = environment.baseUrl;; 

  constructor(private http: HttpClient) { }

  getAllRobots(): Observable<any[]> {
    const url = `${this.baseUrl}/trolleys`; // Reemplaza con la ruta correcta de tu API
    return this.http.get<any[]>(url);
  }
}
