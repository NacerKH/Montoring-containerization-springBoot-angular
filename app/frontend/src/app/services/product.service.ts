import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private apiUrl = 'http://localhost:8082'; 

  constructor(private http: HttpClient) { }

  public fetchAllData(): Observable<any> {

       return this.http.get(`${this.apiUrl}/product`);
  }
  
  public fetchData(id : any): Observable<any> {

    return this.http.get(`${this.apiUrl}/product/stock/${id}`);
  }

  public fetchDataByCategory(category : any): Observable<any> {

    return this.http.get(`${this.apiUrl}/productCategoy/${category}`);
  }

  public addProduct(product: any, idStock : any): Observable<any> {
    
    return this.http.post(`${this.apiUrl}/product/${idStock}`, product);
  }

  public deleteData(id: any) {

    return this.http.delete(`${this.apiUrl}/product/${id}`);
  }


}
