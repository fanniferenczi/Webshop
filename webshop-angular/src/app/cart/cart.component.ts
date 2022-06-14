
import { ProductService } from '../product.service';
import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  constructor(private productService:ProductService) { }

  ngOnInit(): void {
    this.loadData()
    
  }
  
  sum:number=0
  local:any
  data:any[]=[]

  loadData(){
   /* let data:any=localStorage.getItem('session')*/
   
     this.data=this.allStorage()
     for(let i=0; i<this.data.length;i++){
      this.local=JSON.parse(this.data[i])
      this.cartProducts.push(this.local)
      this.sum+=this.cartProducts[i].price
     }
     
     
     
  }
  cartProducts:any[]=[]
 
  allStorage() {

    var values = [],
        keys = Object.keys(localStorage),
        i = keys.length;

    while ( i-- ) {
        values.push( localStorage.getItem(keys[i]) );
    }

    return values;
}

onDelete(p:any){
 const index:number=this.cartProducts.indexOf(p)
 if(index!==-1){
  localStorage.removeItem(this.cartProducts[index].name)
  this.sum-=this.cartProducts[index].price
   this.cartProducts.splice(index,1)
   
   
 }
}

onClear(){
  localStorage.clear()
  this.cartProducts=[]
  this.sum=0;
}

}
