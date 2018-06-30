import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';

import {ContentService} from "../service/content.service";
import {AdminTableModule} from "web-admin-core/main";
import {ContentsComponent} from "./contents.component";


@NgModule({
    imports: [
        AdminTableModule,
        RouterModule.forChild([{ path: '', component: ContentsComponent }]),
    ],
    providers: [ ContentService ],
    declarations: [ ContentsComponent ],
    bootstrap:    [ ContentsComponent ]
})
export class ContentsModule { }
