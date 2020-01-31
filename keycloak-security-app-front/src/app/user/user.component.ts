import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { KeycloakUtilsService } from '../services/keycloak/keycloak-utils.service';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  carts: any;

  constructor(private http: HttpClient, protected keycloakUtils: KeycloakUtilsService) { }

  ngOnInit() {
    this.getUserCartsList();
  }

  getUserCartsList() {
    if (this.keycloakUtils.isLoggedIn) {
      this.http.get(environment.apiUrl + '/customers/carts')
          .subscribe(data => (this.carts = data));
        //.pipe( map( data => this.carts = data ) );
        //.subscribe(data => this.carts = data);
    }
  }
}
