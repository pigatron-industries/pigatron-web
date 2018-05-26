import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';

import {ContentService} from "../service/content.service";
import {AdminWebModule} from "web-admin-core/main";
import {PageComponent} from "./page.component";


@NgModule({
    imports: [
        AdminWebModule,
        RouterModule.forChild([{ path: '', component: PageComponent }]),
    ],
    providers: [ ContentService ],
    declarations: [ PageComponent ],
    bootstrap:    [ PageComponent ]
})
export class PageModule { }
