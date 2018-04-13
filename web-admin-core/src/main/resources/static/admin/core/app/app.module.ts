import {NgModule} from '@angular/core';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {RouterModule} from '@angular/router';
import {FlexLayoutModule} from "@angular/flex-layout";
import {MatButtonModule, MatToolbarModule, MatMenuModule} from '@angular/material';

import {AdminAppComponent} from './app.component';
import {HomeComponent} from './home.component';
import {MenuService} from "./menu/menu.service";
import {routes} from './app.routes';
import {XhrInterceptor} from "./httpinterceptor";
import {MenuItemComponent} from "./menu/menuitem.component";

@NgModule({
    imports: [
        HttpClientModule,
        BrowserModule,
        BrowserAnimationsModule,
        RouterModule.forRoot(routes, { enableTracing: true }),
        FlexLayoutModule,
        MatButtonModule,
        MatToolbarModule,
        MatMenuModule
    ],
    declarations: [ AdminAppComponent, HomeComponent, MenuItemComponent ],
    bootstrap:    [ AdminAppComponent ],
    providers:    [{ provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true }, MenuService]
})
export class AdminAppModule { }

