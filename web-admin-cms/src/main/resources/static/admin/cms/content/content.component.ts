import {Component, Inject} from "@angular/core";
import {ActivatedRoute} from '@angular/router';
import {FormControl, FormGroup, Validators} from "@angular/forms";

import {ContentService} from "../service/content.service";
import {Page} from "../service/page";
import {AbstractFormComponent} from "web-admin-core/main";


@Component({
    selector: 'pg-users',
    templateUrl: '/admin/cms/content/content.component.html'
})
export class ContentComponent extends AbstractFormComponent<Page> {

    type: string;

    form = new FormGroup({
        title: new FormControl('', [
            Validators.required
        ]),
    });

    constructor(@Inject(ContentService) contentService: ContentService,
                @Inject(ActivatedRoute) route: ActivatedRoute) {
        super(contentService, route);
    }

    create(): Page {
        return new Page();
    };

    ngOnInit(): void {
        super.ngOnInit();
        this.route.parent.url.subscribe(url => {
            this.type = url[0].path;
        });
    }

}
