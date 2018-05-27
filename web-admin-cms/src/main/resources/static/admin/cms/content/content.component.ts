import {Component, Inject} from "@angular/core";
import {ActivatedRoute} from '@angular/router';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import * as EditorBuild from '@ckeditor/ckeditor5-build-classic';

import {ContentService} from "../service/content.service";
import {AbstractFormComponent} from "web-admin-core/main";
import {Content} from "../service/content";
import {Page} from "../service/page";
import {Post} from "../service/post";
import {Block} from "../service/block";


@Component({
    selector: 'pg-users',
    templateUrl: '/admin/cms/content/content.component.html'
})
export class ContentComponent extends AbstractFormComponent<Content> {

    EditorBuild = EditorBuild;

    type: string;

    form = new FormGroup({
        title: new FormControl('', [
            Validators.required
        ]),
        urlKey: new FormControl('', [
            Validators.required
        ]),
        publishedDate: new FormControl('', []),
        enabled: new FormControl('', []),
        contentSummary: new FormControl('', []),
        content: new FormControl('', [])
    });

    constructor(@Inject(ContentService) contentService: ContentService,
                @Inject(ActivatedRoute) route: ActivatedRoute) {
        super(contentService, route);
    }

    ngOnInit(): void {
        this.route.parent.url.subscribe(url => {
            this.type = url[0].path;
        });
        super.ngOnInit();
    }

    create(): Content {
        if(this.type == 'page') {
            return new Page();
        }
        if(this.type == 'post') {
            return new Post();
        }
        if(this.type == 'block') {
            return new Block();
        }
    }

}
