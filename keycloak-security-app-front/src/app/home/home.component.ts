import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { KeycloakUtilsService } from '../services/keycloak/keycloak-utils.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  title = 'Welcome my friend, whoever you are';
  adminGreetings;

  constructor(private http: HttpClient, protected keycloakUtils: KeycloakUtilsService) { }

  ngOnInit() {
  }

  login() {
    this.keycloakUtils.login();
  }

  logout() {
    this.keycloakUtils.logout();
  }

}
