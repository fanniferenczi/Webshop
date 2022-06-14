import { ModifyProductComponent } from './modify-product/modify-product.component';
import { NewProductComponent } from './new-product/new-product.component';
import { CartComponent } from './cart/cart.component';
import { BagsComponent } from './bags/bags.component';
import { TrousersComponent } from './trousers/trousers.component';
import { TopsComponent } from './tops/tops.component';
import { ShoesComponent } from './shoes/shoes.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllProductsComponent } from './all-products/all-products.component';
import { EditComponent } from './edit/edit.component';

const routes: Routes = [
  {path:'termekek',component:AllProductsComponent},
  {path:'felsok',component:TopsComponent},
  {path:'nadragok',component:TrousersComponent},
  {path:'cipok',component:ShoesComponent},
  {path:'taskak',component:BagsComponent},
  {path:'kosar',component:CartComponent},
  {path:'szerkesztes',component:EditComponent},
  {path:'ujtermek',component:NewProductComponent},
  {path:'modositas',component:ModifyProductComponent},
  {path:'',component:AllProductsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
