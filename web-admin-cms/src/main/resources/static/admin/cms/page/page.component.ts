import {Component, Inject} from "@angular/core";
import {ActivatedRoute} from '@angular/router';
import {FormGroup} from "@angular/forms";

import {ContentService} from "../service/content.service";
import {Page} from "../service/page";
import {AbstractFormComponent} from "web-admin-core/main";


@Component({
    selector: 'pg-users',
    templateUrl: '/admin/cms/page/page.component.html'
})
export class PageComponent extends AbstractFormComponent<Page> {

    form = new FormGroup({
        // username: new FormControl('', [
        //     Validators.required
        // ]),
    });

    constructor(@Inject(ContentService) contentService: ContentService,
                @Inject(ActivatedRoute) route: ActivatedRoute) {
        super(contentService, route);
    }

    create(): Page {
        return new Page();
    };

}
