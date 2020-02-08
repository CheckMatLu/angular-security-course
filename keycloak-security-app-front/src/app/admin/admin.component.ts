import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakUtilsService } from '../services/keycloak/keycloak-utils.service';
import { DataService } from '../services/data/data.service';
import { UserItem } from './user-item/user-item.model';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  currentUserName: string;
  users: any;

  constructor(private http: HttpClient,
              protected keycloakAngular: KeycloakService,
              protected keycloakUtils: KeycloakUtilsService,
              protected dataService: DataService) { }

  ngOnInit() {
    this.currentUserName = this.keycloakUtils.getUserName();
    this.getAllUsers();
  }

  getAllUsers() {
    this.dataService.getUsersList().subscribe(users => this.users = users);
  }
}
