import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) { }

  getUnsecureData() {
    return this.http.get(environment.apiUrl + '/', {responseType: 'text'});
  }
  getUserData() {
    return this.http.get(environment.apiUrl + '/user', {responseType: 'text'});
  }
  getAdminData() {
    return this.http.get(environment.apiUrl + '/admin', {responseType: 'text'});
  }
}
