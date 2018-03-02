import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
//import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';

import { PageComponent }   from './content/page/page.component';
import { routes } from './cms.routes';


@NgModule({
    imports: [
        BrowserModule,
        //BrowserAnimationsModule,
        RouterModule.forRoot(routes, { enableTracing: true })
    ],
    declarations: [ PageComponent ],
    bootstrap:    [ PageComponent ]
})
export class CmsModule { }
