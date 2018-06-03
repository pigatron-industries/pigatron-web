import {Inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {AbstractDataService} from "web-public-core/main";
import {Content} from "./content";
import {Observable} from "rxjs";
import {Page} from "./page";

@Injectable()
export class ContentService extends AbstractDataService<Content> {

    constructor(@Inject(HttpClient) http: HttpClient) {
        super(http, 'api/cms/content');
    }

    getByUrl(urlKey: string): Observable<Page> {
        return <Observable<Page>>this.http.get(this.basePath+'/page?urlKey='+urlKey);
    }

}