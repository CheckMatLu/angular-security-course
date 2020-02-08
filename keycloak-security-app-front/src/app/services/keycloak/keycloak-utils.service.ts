import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class KeycloakUtilsService {

  constructor(protected keycloakAngular: KeycloakService, private router: Router) { }

  isLoggedIn = false;

  public getUserName(): string {
    return this.keycloakAngular.getUsername();
  }

  public loadUserProfile() {
    return this.keycloakAngular.getKeycloakInstance()
      .loadUserInfo();
  }

  isAuthenticated() {
    this.keycloakAngular.isLoggedIn().then(
        value => {
          this.isLoggedIn = value;
        });
  }

  hasRole(role: string){
    const roles: string[] = this.keycloakAngular.getUserRoles();
    return roles.indexOf(role) > -1;
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
