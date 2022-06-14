import { ProductService } from './../product.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private productService:ProductService) { }

  ngOnInit(): void {
    this.productService.sendProducts.subscribe(array=>{
      this.test=array;
      console.log(this.test)
    })
    
  }

  menuItems=[
    {linkId:1, linkName: 'Termékek', linkUrl:'termekek'},
    {linkId:2, linkName: 'Felsők', linkUrl:'felsok'},
    {linkId:3, linkName: 'Nadrágok', linkUrl:'nadragok'},
    {linkId:4, linkName: 'Cipők', linkUrl:'cipok'},
    {linkId:5, linkName: 'Táskák', linkUrl:'taskak'}
  ]

  test:any

}
