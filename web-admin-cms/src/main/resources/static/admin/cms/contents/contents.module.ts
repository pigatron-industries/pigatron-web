import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';

import {ContentService} from "../service/content.service";
import {AdminWebModule} from "web-admin-core/main";
import {ContentsComponent} from "./contents.component";


@NgModule({
    imports: [
        AdminWebModule,
        RouterModule.forChild([{ path: '', component: ContentsComponent }]),
    ],
    providers: [ ContentService ],
    declarations: [ ContentsComponent ],
    bootstrap:    [ ContentsComponent ]
})
export class ContentsModule { }
