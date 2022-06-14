
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { ModalDismissReasons, NgbModal, NgbModalConfig } from '@ng-bootstrap/ng-bootstrap';
import { createPopper } from '@popperjs/core';
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { NotificationsService } from 'angular2-notifications';
import {MatDialogModule, MatDialogConfig, MatDialog} from '@angular/material/dialog';


@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css'],
  providers: [NgbModalConfig, NgbModal]
})
export class EditComponent implements OnInit {
  
 

  constructor(private productService:ProductService,private notificationService:NotificationsService) { 
    
  }
  ngOnInit(): void {
    this.getProducts();
    
  }

  
  public products?:Product[]

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

onDelete(product:any){
  if(confirm("Biztosan szeretné törölni "+ product.name+" nevű terméket?")){
    this.productService.deleteProduct(product.id).subscribe(
      (response:void)=>{
        console.log(response)
        this.getProducts()
        this.onSuccess("Termék törölve")
      },
      (error: HttpErrorResponse)=>{
        alert(error.message)
      }
    )
  }
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
saveForModifying(product:Product){
  let data={
    id:product.id,
    name:product.name,
    price:product.price,
    description:product.description,
    imageUrl:product.imageUrl,
    catId:product.category.id,
    catName:product.category.name
  }
  localStorage.setItem("modify",JSON.stringify(data))
}



}
