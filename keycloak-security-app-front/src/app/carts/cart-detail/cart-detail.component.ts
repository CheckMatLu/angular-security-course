import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Cart } from '../cart.model';
import { DataService } from 'src/app/services/data/data.service';

@Component({
  selector: 'app-cart-detail',
  templateUrl: './cart-detail.component.html',
  styleUrls: ['./cart-detail.component.css']
})
export class CartDetailComponent implements OnInit {

  cartId: number;
  userId: string;
  cart: Cart;

  constructor(private route: ActivatedRoute, private dataService: DataService) { }

  ngOnInit() {
    this.route.params
      .subscribe(
        (params: Params) => {

          this.userId = params.userId;
          this.cartId = +params.id;

          this.dataService.getCart(this.userId, this.cartId).subscribe(
            (data: Cart) => (this.cart = data)
          );
        }
      );
  }

}
