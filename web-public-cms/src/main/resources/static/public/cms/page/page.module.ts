import { NgModule }      from '@angular/core';
import { CommonModule } from '@angular/common';
//import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';

import { PageComponent }   from './page.component';
import { routes } from './page.route';


@NgModule({
    imports: [
        CommonModule,
        //BrowserAnimationsModule,
        RouterModule.forChild(routes)
    ],
    declarations: [ PageComponent ],
    bootstrap:    [ PageComponent ]
})
export class PageModule { }
