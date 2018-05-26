import {Inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {AbstractDataService} from "web-admin-core/main";
import {Content} from "./content";

@Injectable()
export class ContentService extends AbstractDataService<Content> {

    constructor(@Inject(HttpClient) http: HttpClient) {
        super(http, 'api/cms/content');
    }

}