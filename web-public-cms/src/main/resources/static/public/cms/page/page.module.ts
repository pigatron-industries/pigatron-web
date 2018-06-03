import {NgModule}     from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {HttpClientModule} from "@angular/common/http";

import {PageComponent}  from './page.component';
import {ContentService} from "../service/content.service";


@NgModule({
    imports: [
        CommonModule,
        HttpClientModule,
        RouterModule.forChild([{ path: ':urlKey', component: PageComponent }])
    ],
    providers: [ ContentService ],
    declarations: [ PageComponent ],
    bootstrap:    [ PageComponent ]
})
export class PageModule { }
