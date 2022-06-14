import { ProductService } from './../product.service';
import { NgToastModule } from 'ng-angular-popup';
import { Category } from './../product';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { NotificationsService } from 'angular2-notifications';
import { Product } from '../product';
import { ThisReceiver } from '@angular/compiler';

@Component({
  selector: 'app-modify-product',
  templateUrl: './modify-product.component.html',
  styleUrls: ['./modify-product.component.css']
})
export class ModifyProductComponent implements OnInit {

  constructor(private productService:ProductService, private notificationService:NotificationsService) { }

  category:Category={
    id:0,
    name:''
  }
  product:Product={
    id:0,
    name:'',
    description:'',
    price:0,
    imageUrl:'',
    category:this.category
    }
  

  ngOnInit(): void {
    let data:any=localStorage.getItem('modify')
    let tmp=JSON.parse(data);
  
    this.product.id=tmp.id
    this.product.name=tmp.name
    this.product.price=tmp.price
    this.product.description=tmp.description
    this.product.imageUrl=tmp.imageUrl
    this.product.category.id=tmp.catId
    this.product.category.name=tmp.catName

    
    
   }
  

   onModifyProduct(form:NgForm){
    if(form.value.name!=''){
      this.product.name=form.value.name
    }
    if(form.value.description!=''){
      this.product.description=form.value.description
    }
    
    if(form.value.description!=''){
      this.product.description=form.value.description
    }
    if(form.value.imageUrl!=''){
      this.product.imageUrl=form.value.imageUrl
    }
    if(form.value.price!=0){
      this.product.price=form.value.price
    }
    
    
   switch(form.value.category){
     case '1':{
       this.product.category.id=1
       this.product.category.name='Felsők'
       break
     }
     case '2':{
       this.product.category.id=2
       this.product.category.name='Nadrágok'
       console.log("kettes")
       break
     }
     case '3':{
      this.product.category.id=3
      this.product.category.name='Cipők'
      break
     }
     case '4':
      this.product.category.id=4
      this.product.category.name='Táskák'
      break
   }



    this.productService.updateProduct(this.product).subscribe(
      (response:Product)=>{
        console.log(response)
        this.onSuccess("Termék adatai módosításra kerültek")
      },
      (error: HttpErrorResponse)=>{
        alert(error.message)
      }
    )


     



   }

  
    onSuccess(message:string){
       
      this.notificationService.success('Sikeres művelet',message,{
        position:['bottom','right'],
        timeOut: 2000,
        animate:'fade',
        showProgressBar: false,
        pauseOnHover: true
      })
      
    
    }
   
   
  



  onModify(){
  }

}
