import {Component, Inject} from "@angular/core";

import {ContentService} from "../service/content.service";
import {Content} from "../service/content";
import {AbstractTableComponent} from "web-admin-core/main";


@Component({
    selector: 'pg-contents',
    templateUrl: '/admin/cms/contents/contents.component.html'
})
export class ContentsComponent extends AbstractTableComponent<Content> {

    constructor(@Inject(ContentService) contentService: ContentService) {
        super(contentService);
    }

}
