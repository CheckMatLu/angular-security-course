import { Product } from '../product/product.model';

export class Cart {

  id: number;
  name: string;
  products: Product[];

  constructor(id: number, name: string, products: Product[]) {
    this.id = id;
    this.name = name;
    this.products = products;
  }
}
