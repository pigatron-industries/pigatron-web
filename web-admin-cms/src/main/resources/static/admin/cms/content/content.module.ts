import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';

import {ContentService} from "../service/content.service";
import {AdminFormModule} from "web-admin-core/main";
import {ContentComponent} from "./content.component";
import {CKEditorComponent} from "../ckeditor/ckeditor.component";


@NgModule({
    imports: [
        AdminFormModule,
        RouterModule.forChild([{ path: '', component: ContentComponent }]),
    ],
    providers: [ ContentService ],
    declarations: [ ContentComponent, CKEditorComponent ],
    bootstrap:    [ ContentComponent ]
})
export class ContentModule { }
