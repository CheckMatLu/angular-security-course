import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { KeycloakUtilsService } from '../services/keycloak/keycloak-utils.service';
import { map } from 'rxjs/operators';
import { DataService } from '../services/data/data.service';
import { Cart } from '../carts/cart.model';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  userLoaded: Promise<boolean>;
  userProfile;

  constructor(private http: HttpClient, protected keycloakUtils: KeycloakUtilsService) { }

  ngOnInit() {
    this.loadUser();
  }

  loadUser() {

    if ( this.keycloakUtils.isLoggedIn) {
      if ( ! this.userProfile ) {
        this.keycloakUtils.loadUserProfile().success(
          value => {
              this.userProfile = value;
              this.userLoaded = Promise.resolve(true);
          }
        );
      }
    }

  }
}
