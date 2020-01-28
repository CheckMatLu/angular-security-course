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

  public getUserName(): string {
    return this.keycloakAngular.getUsername();
  }


  login(): void {

    // const keycloakLoginOptions: KeycloakLoginOptions = {
    //   prompt: 'login',
    //   redirectUri: location.origin
    // };

    this.keycloakAngular.isLoggedIn().then(
      response => {
        if ( !response ) {
            this.keycloakAngular.login();
        }
      });
  }

  logout(): void {

    this.keycloakAngular.isLoggedIn().then(
        response => {
          if ( response ) {
              this.keycloakAngular.logout(location.origin);
          }
        });
  }
}
