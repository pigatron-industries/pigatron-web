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
        //extraPlugins: 'wpmore',
        //toolbar: [
            //{ name: 'clipboard', items: [ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo' ] },
            //{ name: 'tools', items: [ 'Maximize' ] },
            //'/',
            //{ name: 'styles', items: [ 'Styles', 'Format', '-' ] },
            //{ name: 'basicstyles', items: [ 'Bold', 'Italic', 'Strike', '-', 'RemoveFormat', '-' ] },
            //{ name: 'paragraph', items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote', '-' ] },
            //{ name: 'links', items: [ 'Link', 'Unlink', '-' ] },
            //{ name: 'insert', items: [ 'Image', 'Table', 'HorizontalRule', 'SpecialChar', 'WPMore' ] },
            //{ name: 'document', items: [ 'Source' ] }
        //],
        //removeButtons: 'Underline,Subscript,Superscript,About,Anchor,Scayt',
        //format_tags: 'p;h1;h2;h3;pre'
        //removeDialogTabs: 'image:advanced;link:advanced'
    };

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
