import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NotificationsService } from 'angular2-notifications';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-trousers',
  templateUrl: './trousers.component.html',
  styleUrls: ['./trousers.component.css']
})
export class TrousersComponent implements OnInit {
  public products?:Product[]
  constructor(private productService:ProductService, private notificationService:NotificationsService) { }

  ngOnInit(): void {
    this.getProducts();
  }
  public getProducts():void{
    this.productService.getProductsByCategory(2).subscribe(
      (response:Product[])=>{ //if get this back, then we execute some code
        this.products=response  // set the products variable to what we got from the service
      },
      (error:HttpErrorResponse)=>{
        alert(error.message)
      }
    )
  }
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

}
