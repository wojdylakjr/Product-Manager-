import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl="http://localhost:8080/products";
  constructor(private httpClient: HttpClient ) { }

  getProductList(): Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${this.baseUrl}`);
  }

  createProduct(product: Product): Observable<any>{
    return this.httpClient.post(`${this.baseUrl}`,product);
  }

  getProductById(id:number):Observable<Product>{
    return this.httpClient.get<Product>(`${this.baseUrl}/${id}`);
  }

  updateProduct(id:number, product: Product):Observable<Object>{
    return this.httpClient.put<Product>(`${this.baseUrl}/${id}`, product);
  }

  deleteProduct(id:number):Observable<Object>{
    return this.httpClient.delete<Product>(`${this.baseUrl}/${id}`);
  }
}
