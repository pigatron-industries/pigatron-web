import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';

import { AdminAppComponent }   from './app.component';
import { HomeComponent } from './home.component';
import { appRoutes } from './app.routes';

@NgModule({
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        RouterModule.forRoot(appRoutes, { enableTracing: true })
    ],
    declarations: [ AdminAppComponent, HomeComponent ],
    bootstrap:    [ AdminAppComponent ]
})
export class AdminAppModule { }
