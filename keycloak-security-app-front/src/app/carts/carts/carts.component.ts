import { Component, OnInit, Input } from '@angular/core';
import { Cart } from '../cart.model';
import { KeycloakUtilsService } from 'src/app/services/keycloak/keycloak-utils.service';
import { DataService } from 'src/app/services/data/data.service';

@Component({
  selector: 'app-carts',
  templateUrl: './carts.component.html',
  styleUrls: ['./carts.component.css']
})
export class CartsComponent implements OnInit {

  @Input() userId: string;
  carts: Cart[];

  constructor(private keycloakUtils: KeycloakUtilsService, protected dataService: DataService) { }

  ngOnInit() {
    this.getUserCartsList();
  }

  getUserCartsList() {

    if ( this.userId ) {
      this.dataService.getCustomerCarts( this.userId )
        .subscribe((data: Cart[]) => (this.carts = data));
    }

  }
}
