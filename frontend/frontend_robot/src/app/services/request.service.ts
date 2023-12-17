import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  baseUrl = environment.baseUrl;

  constructor(private httpClient: HttpClient) { }

  url = this.baseUrl + '/requests';

  getRequests(): Observable<any[]> {
    return this.httpClient.get<any[]>(this.url);
  }

  getRequest(id: number): Observable<any> {
    return this.httpClient.get<any>(this.url + '/' + id);
  }

  createRequest(requestData: any): Observable<any> {
    return this.httpClient.post(this.url, requestData);
  }

  updateRequest(requestData: any): Observable<any> {
    return this.httpClient.put(this.url, requestData);
  }

  deleteRequest(id: number): Observable<any> {
    return this.httpClient.delete(this.url + '/' + id);
  }
}
