// robot.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import {Robot} from '../robot';
import { Observable, catchError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RobotService {

  baseUrl = environment.baseUrl;

    constructor(private httpClient: HttpClient) { }

    url = this.baseUrl + '/trolleys';

    getRobots(){
      return this.httpClient.get<JSON[]>(this.url);
    }

    getRobot(id: number){
      return this.httpClient.get<JSON>(this.url + '/' + id);
    }
    
    createRobot(data: Robot){
      return this.httpClient.post(this.url, data)
    }

    updateRobot(data: Robot){
      return this.httpClient.put(this.url, data)
    }

    deleteRobot(id: number){
      return this.httpClient.delete(this.url + '/' + id)
    }

    changeTrolleyState(trolleyId: number, newState: boolean): Observable<any> {
      const url = `${this.baseUrl}/trolleys/${trolleyId}/change-state/${newState}`;
      return this.httpClient.patch(url, null);
  }

    

}
