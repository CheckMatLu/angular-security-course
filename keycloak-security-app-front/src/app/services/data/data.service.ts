import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) { }

  getUsersList() {
    return this.http.get(environment.apiUrl + '/admin/users');
  }

  getCustomerCarts( userId: string ) {
    return this.http.get(environment.apiUrl + '/customers/' + userId + '/carts');
  }

  getCart( userId: string, cartId: number ) {
    return this.http.get(environment.apiUrl + '/customers/' + userId + '/carts/' + cartId);
  }
}
