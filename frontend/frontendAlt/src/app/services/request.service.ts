import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Request } from '../request';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  baseUrl = environment.baseUrl;

  constructor(private httpClient: HttpClient) { }

    url = this.baseUrl + '/request';
    
    getRequests(){
      return this.httpClient.get<JSON[]>(this.url);
    }

    acceptRequest(requestId: number): Observable<any> {
      const url = `${this.baseUrl}/request/accept/${requestId}`;
      return this.httpClient.put(url, null);
    }

    getRequest(id: number){
      return this.httpClient.get<JSON>(this.url + '/' + id);
    }
    
    createRequest(data: Request){
      return this.httpClient.post(this.url, data)
    }

    updateRequest(data: Request){
      return this.httpClient.put(this.url, data)
    }

    deleteRequest(id: number){
      return this.httpClient.delete(this.url + '/' + id)
    }

}
