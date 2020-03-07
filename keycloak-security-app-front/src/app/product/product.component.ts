import { Component, OnInit, Input } from '@angular/core';
import { DataService } from '../services/data/data.service';
import { Cart } from '../carts/cart.model';
import { Product } from './product.model';
import { KeycloakUtilsService } from '../services/keycloak/keycloak-utils.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  products: Product[];

  constructor(protected keycloakUtils: KeycloakUtilsService, protected dataService: DataService) { }

  ngOnInit() {
  }
}
