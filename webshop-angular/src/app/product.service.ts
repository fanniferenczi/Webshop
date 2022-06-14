import { environment } from './../environments/environment';
import { Injectable } from '@angular/core';
import { Observable, observable, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private apiServerUrl=environment.apiBaseUrl
  
  constructor(private http:HttpClient) { }

  public getProducts():Observable<Product[]>{
    return this.http.get<Product[]>(`${this.apiServerUrl}/product/all`)
  }

  public addProduct(product:Product,catid:number):Observable<Product>{
    return this.http.post<Product>(`${this.apiServerUrl}/product/add/${catid}`,product)
  }

  public updateProduct(product:Product):Observable<Product>{
    return this.http.put<Product>(`${this.apiServerUrl}/product/update`,product)
  }

  public deleteProduct(productId:number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/product/delete/${productId}`)
  }

  public getProductsByCategory(categoryId:number):Observable<Product[]>{
    return this.http.get<Product[]>(`${this.apiServerUrl}/product/catid/${categoryId}`)
  }


  sendProducts=new Subject()
  communicateProduct(product:any){
    this.sendProducts.next(product)
  }
}
