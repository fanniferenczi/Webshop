import { MatDialogModule } from '@angular/material/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './header/header.component';
import { AllProductsComponent } from './all-products/all-products.component';
import { TopsComponent } from './tops/tops.component';
import { TrousersComponent } from './trousers/trousers.component';
import { ShoesComponent } from './shoes/shoes.component';
import { BagsComponent } from './bags/bags.component';
import { CartComponent } from './cart/cart.component';
import { EditComponent } from './edit/edit.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { createPopper } from '@popperjs/core';
import { NewProductComponent } from './new-product/new-product.component';
import { SimpleNotificationsModule } from 'angular2-notifications';
import { NgToastModule } from 'ng-angular-popup';
import { ModifyProductComponent } from './modify-product/modify-product.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AllProductsComponent,
    TopsComponent,
    TrousersComponent,
    ShoesComponent,
    BagsComponent,
    CartComponent,
    EditComponent,
    NewProductComponent,
    ModifyProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    SimpleNotificationsModule.forRoot(),
    BrowserAnimationsModule,
    NgToastModule,
    MatDialogModule,
    ReactiveFormsModule 
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
