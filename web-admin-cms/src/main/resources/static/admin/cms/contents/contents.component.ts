import {Component, Inject} from "@angular/core";

import {ContentService} from "../service/content.service";
import {Content} from "../service/content";
import {AbstractTableComponent} from "web-admin-core/main";


@Component({
    selector: 'pg-contents',
    templateUrl: '/admin/cms/contents/contents.component.html'
})
export class ContentsComponent extends AbstractTableComponent<Content> {

    columns = [{
        prop: 'type',
        width: 100
    }, {
        prop: 'title',
        width: 600
    }, {
        prop: 'enabled',
        width: 200
    }, {
        prop: 'publishedDate',
        width: 200
    }];

    constructor(@Inject(ContentService) contentService: ContentService) {
        super(contentService);
    }

}
