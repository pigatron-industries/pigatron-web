import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { PublicAppComponent }   from './app.component';

@NgModule({
    imports:      [ BrowserModule, BrowserAnimationsModule ],
    declarations: [ PublicAppComponent ],
    bootstrap:    [ PublicAppComponent ]
})
export class PublicAppModule { }
