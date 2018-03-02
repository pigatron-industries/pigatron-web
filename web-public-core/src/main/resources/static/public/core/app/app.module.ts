import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';

import { routes } from './app.routes';
import { PublicAppComponent }   from './app.component';
import { HomeComponent } from './home.component';


@NgModule({
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        RouterModule.forRoot(routes, { enableTracing: true })
    ],
    declarations: [ PublicAppComponent, HomeComponent ],
    bootstrap:    [ PublicAppComponent ]
})
export class PublicAppModule { }
