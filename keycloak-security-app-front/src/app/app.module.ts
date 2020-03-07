import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ApplicationRef, DoBootstrap } from '@angular/core';
import { MatCardModule
        , MatIconModule
        , MatToolbarModule
        , MatButtonModule
        , MatFormFieldModule
        , MatInputModule
        , MatSidenavModule
        , MatTooltipModule
        , MatListModule
        , MatCheckboxModule } from '@angular/material';
import { FlexLayoutModule } from '@angular/flex-layout';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { KeycloakService, KeycloakAngularModule } from 'keycloak-angular';
import { environment } from 'src/environments/environment';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './header/header.component';
import { ProductComponent } from './product/product.component';
import { ProductItemComponent } from './product/product-item/product-item.component';
import { CartDetailComponent } from './carts/cart-detail/cart-detail.component';
import { CartsComponent } from './carts/carts/carts.component';
import { CartItemComponent } from './carts/cart-item/cart-item.component';
import { UserItemComponent } from './user/user-item/user-item.component';


const keycloakService = new KeycloakService();

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AdminComponent,
    UserComponent,
    HeaderComponent,
    UserItemComponent,
    CartItemComponent,
    ProductComponent,
    ProductItemComponent,
    CartDetailComponent,
    CartsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    KeycloakAngularModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    MatCardModule,
    MatIconModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatToolbarModule,
    MatSidenavModule,
    MatTooltipModule,
    MatListModule,
    MatCheckboxModule
  ],
  providers: [
    {
      provide: KeycloakService,
      useValue: keycloakService
    }
  ],
  entryComponents: [AppComponent]
})
export class AppModule implements DoBootstrap {
  ngDoBootstrap(appRef: ApplicationRef) {
    keycloakService
      .init(environment.keycloak)
      .then(() => {
        console.log('[ngDoBootstrap] bootstrap app');

        appRef.bootstrap(AppComponent);
      })
      .catch(error => console.error('[ngDoBootstrap] init Keycloak failed', error));
  }
}
