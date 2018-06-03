import {Component, OnInit} from "@angular/core";
import {ActivatedRoute} from "@angular/router";
import {Inject} from "@angular/core";
import {Page} from "../service/page";
import {ContentService} from "../service/content.service";


@Component({
    selector: 'pg-page',
    templateUrl: '/public/cms/page/page.component.html'
})
export class PageComponent implements OnInit {

    public loaded: boolean = false;
    public page: Page;


    constructor(@Inject(ActivatedRoute) protected route : ActivatedRoute,
                @Inject(ContentService) protected contentService: ContentService) {
    }

    ngOnInit() {
        this.loaded = true;
        this.route.params.subscribe(params => {
            this.load(params['urlKey']);
        });
    }

    load(urlKey) {
        this.contentService.getByUrl(urlKey)
            .subscribe(page => {
                this.page = page;
                this.loaded = true;
            });
    }

}
