import { ProductService } from './product.service';
import { Product } from './product';
import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  //public products?:Product[]
  constructor(/*private productService:ProductService*/) { }
  ngOnInit(): void {
    //this.getProducts();
  }
/*
  public getProducts():void{
    this.productService.getProducts().subscribe(
      (response:Product[])=>{ //if get this back, then we execute some code
        this.products=response  // set the products variable to what we got from the service
      },
      (error:HttpErrorResponse)=>{
        alert(error.message)
      }
    )
  }

  public getProducts():void{
    this.productService.getProductsByCategory(1).subscribe(
      (response:Product[])=>{ //if get this back, then we execute some code
        this.products=response  // set the products variable to what we got from the service
      },
      (error:HttpErrorResponse)=>{
        alert(error.message)
      }
    )
  }*/


}
