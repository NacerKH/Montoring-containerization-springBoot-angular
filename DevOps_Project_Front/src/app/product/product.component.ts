import { Component } from '@angular/core';
import { ProductService } from '../services/product.service';
import { ActivatedRoute } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { StockService } from '../services/stock.service';


@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {

  data: any;
  closeResult!: string;
  form: boolean = false;
  stock: any;
  product: {
    title: any;
    category: any;
    price: any;
    quantity: any;
  } = {
      title: null,
      category: null,
      price: null,
      quantity: null
    };

  constructor(private productService: ProductService, private route: ActivatedRoute, private modalService: NgbModal,
    private stockService: StockService) { }

  ngOnInit() {
    this.fetchData();
    this.getStock();
  }

  fetchData() {
    const id = this.route.snapshot.paramMap.get('id');
    console.log(id);
    this.productService.fetchData(id).subscribe((response) => {
      this.data = response;
    });
  }

  addProduct(product: any) {
    const id = this.route.snapshot.paramMap.get('id');
    return this.productService.addProduct(product, id).subscribe((response) => {
      this.data = response;
      this.fetchData();
    });
  }




  open(content: any) {
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }
  closeForm() {

  }
  cancel() {
    this.form = false;
  }

  getStock() {
    const id = this.route.snapshot.paramMap.get('id');
    return this.stockService.fetchData(id).subscribe((response) => {
      this.stock = response;
    });
  }

  deleteItem(itemId: any) {
    if (confirm('Are you sure you want to delete this item?')) {
    this.productService.deleteData(itemId).subscribe(
      () => {
        console.log('Item deleted');
        this.fetchData();
      });
  }}

}
