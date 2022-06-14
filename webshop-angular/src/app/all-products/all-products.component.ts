import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NotificationsService } from 'angular2-notifications';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-all-products',
  templateUrl: './all-products.component.html',
  styleUrls: ['./all-products.component.css']
})
export class AllProductsComponent implements OnInit {
 
  constructor(private productService:ProductService, private notificationService:NotificationsService) { }

  ngOnInit(): void {
    this.getProducts();
  }

  public products?:Product[]
  public addedProducts:Product[]=[]

  onAdd(product:Product){
    let data={id:product.id,name:product.name,price:product.price}
    localStorage.setItem(product.name,JSON.stringify(data))
    this.onSuccess("Termék hozzáadva a kosárhoz")
  }

  onSuccess(message:string){
     
    this.notificationService.success('Sikeres művelet',message,{
      position:['bottom','right'],
      timeOut: 2000,
      animate:'fade',
      showProgressBar: false,
      pauseOnHover: true
    })
    console.log("henlo")
  
  }
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


}
