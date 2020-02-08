import { Component, OnInit } from '@angular/core';
import { KeycloakUtilsService } from '../services/keycloak/keycloak-utils.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  title = 'Keycloack demo test page ';

  constructor( protected keycloakUtils: KeycloakUtilsService ) { }

  ngOnInit() {
    this.keycloakUtils.isAuthenticated();
  }

  login() {
    this.keycloakUtils.login();
  }

  logout() {
    this.keycloakUtils.logout();
  }

  isAuthenticated(): boolean {
    return this.keycloakUtils.isLoggedIn;
  }

  hasAdminRole() {
    return this.keycloakUtils.hasRole( 'ADMIN' );
  }

  hasUserRole() {
    return this.keycloakUtils.hasRole( 'USER' );
  }
}
