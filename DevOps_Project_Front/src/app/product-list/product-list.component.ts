import { Component } from '@angular/core';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {

  data: any;
  searchCategory: string = '';
  constructor(private productService : ProductService) { }
  ngOnInit() {
    this.fetchData();
  }

  fetchData() {
    this.productService.fetchAllData().subscribe((response) => {
      this.data = response;
    });
  }

  get filteredData(): any[] {
    if (this.searchCategory.trim() === '') {
      return this.data;
    } else {
      return this.data.filter((data: { category: string; }) => data.category.toLowerCase().includes(this.searchCategory.toLowerCase()));
    }
  }


}
