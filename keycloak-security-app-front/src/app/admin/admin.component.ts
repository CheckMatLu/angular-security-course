import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakUtilsService } from '../services/keycloak/keycloak-utils.service';
import { DataService } from '../services/data/data.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  adminGreetings;
  userName;

  constructor(private http: HttpClient,
              protected keycloakAngular: KeycloakService,
              protected keycloakUtils: KeycloakUtilsService,
              protected dataService: DataService) { }

  ngOnInit() {
  }

  getAdminGreetings() {
    this.dataService.getAdminData().subscribe(data => this.adminGreetings = data);
    this.userName = this.keycloakUtils.getUserName();
  }
}
