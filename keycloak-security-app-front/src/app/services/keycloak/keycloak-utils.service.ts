import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class KeycloakUtilsService {

  constructor(protected keycloakAngular: KeycloakService, private router: Router) { }

  public getUserName(): string {
    return this.keycloakAngular.getUsername();
  }

  login(): void {
    if ( !this.keycloakAngular.isLoggedIn ) {
      this.keycloakAngular.login();
    }
  }

  logout(): void {
    if ( this.keycloakAngular.isLoggedIn ) {
      this.keycloakAngular.logout(location.origin);
    } else {
      this.router.navigate(['/home']);
    }
  }
}
