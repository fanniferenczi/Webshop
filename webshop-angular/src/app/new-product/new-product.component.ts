import { HttpErrorResponse } from '@angular/common/http';
import { ProductService } from './../product.service';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Product } from '../product';
import { NotificationsService } from 'angular2-notifications';
import { NgToastService } from 'ng-angular-popup';

@Component({
  selector: 'app-new-product',
  templateUrl: './new-product.component.html',
  styleUrls: ['./new-product.component.css']
})
export class NewProductComponent implements OnInit {

  constructor(private productService:ProductService, private notificationService:NotificationsService) { }

  ngOnInit(): void {
  }

  selectedCategory:number=0

  selectChangeHandler(event:any){
    this.selectedCategory=event.target.value
  }
  

  public onAddProduct(addForm:NgForm){
      
    this.productService.addProduct(addForm.value,this.selectedCategory).subscribe(
      (response:Product)=>{
        console.log(addForm.value.name);
        console.log("value: " + addForm.value)
        this.onSuccess("Termék létrehozva")
        addForm.reset()
      },
      (error: HttpErrorResponse)=>{
        alert(error.message +"\nTermék kategóriát választott?")
      }
    )

    console.log(addForm.value)
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
