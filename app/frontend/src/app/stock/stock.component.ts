import {Component} from '@angular/core';
import {StockService} from '../services/stock.service';
import {MatDialog} from '@angular/material/dialog';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent {

  data: any;
  displayForm = false;
  stock: any
  formData = {
    title: ''
  };

  constructor(private stockService: StockService, private dialog: MatDialog) {
  }

  ngOnInit() {
    this.fetchData();
    this.stock = {
      idStock: null,
      title: null
    }
  }

  fetchData() {
    this.stockService.fetchAllData().subscribe((response) => {
      this.data = response;
    });
  }

  showForm() {
    this.displayForm = true;
  }

  submitForm() {
   // Hide the form after submission
    this.displayForm = false;
  }

  addStock(stock: any) {
    return this.stockService.addStock(stock).subscribe((response) => {
      this.data = response;
      this.displayForm = false;
      this.fetchData();
    });
  }

}
