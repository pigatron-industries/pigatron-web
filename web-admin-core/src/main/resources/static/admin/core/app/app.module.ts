import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AdminAppComponent }   from './app.component';

@NgModule({
    imports:      [ BrowserModule, BrowserAnimationsModule ],
    declarations: [ AdminAppComponent ],
    bootstrap:    [ AdminAppComponent ]
})
export class AdminAppModule { }
