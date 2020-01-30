import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { KeycloakLoginOptions } from 'keycloak-js';

@Injectable({
  providedIn: 'root'
})
export class KeycloakUtilsService {

  constructor(protected keycloakAngular: KeycloakService, private router: Router) { }

  isLoggedIn = false;

  public getUserName(): string {
    return this.keycloakAngular.getUsername();
  }

  isAuthenticated() {
    this.keycloakAngular.isLoggedIn().then(
        value => {
          this.isLoggedIn = value;
        });
  }

  login(): void {

    // const keycloakLoginOptions: KeycloakLoginOptions = {
    //   prompt: 'login',
    //   redirectUri: location.origin
    // };

    if ( !this.isLoggedIn ) {
      this.keycloakAngular.login();
    }
  }

  logout(): void {

    if ( this.isLoggedIn ) {
      this.keycloakAngular.logout(location.origin);
    }
  }
}
