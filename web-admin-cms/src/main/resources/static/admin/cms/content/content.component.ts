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
        urlKey: new FormControl('', []),
        publishedDate: new FormControl('', []),
        enabled: new FormControl('', []),
        content: new FormControl('', [])
    });

    editorConfig = {
        heading: {
            options: [
                { model: 'heading1', view: 'h1', title: 'Heading 1' },
                { model: 'heading2', view: 'h2', title: 'Heading 2' },
                { model: 'heading3', view: 'h3', title: 'Heading 3' },
                { model: 'paragraph', view: 'p', title: 'Paragraph' },
                { model: 'preformatted', view: 'pre', title: 'Preformatted' },
            ]
        }
    };

    constructor(@Inject(ContentService) contentService: ContentService,
                @Inject(ActivatedRoute) route: ActivatedRoute) {
        super(contentService, route);
    }

    ngOnInit(): void {
        super.ngOnInit();
    }

    create(params): void {
        if(params['type'] == 'page') {
            this.data = new Page();
        }
        if(params['type'] == 'post') {
            this.data = new Post();
        }
        if(params['type'] == 'block') {
            this.data = new Block();
        }
    }

}
