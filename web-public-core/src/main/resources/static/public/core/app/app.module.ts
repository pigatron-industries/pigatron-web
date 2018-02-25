import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { PublicAppComponent }   from './app.component';

@NgModule({
    imports:      [ BrowserModule ],
    declarations: [ PublicAppComponent ],
    bootstrap:    [ PublicAppComponent ]
})
export class PublicAppModule { }
