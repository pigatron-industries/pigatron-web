import { Injectable, Inject } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from "rxjs";

import {AbstractDataService} from "web-admin-core/main";

@Injectable()
export class UserService extends AbstractDataService {

    constructor(@Inject(HttpClient) http: HttpClient) {
        super(http, 'api/security/user');
    }

    authenticate(credentials): Observable<Object> {
        const headers = new HttpHeaders(credentials ? {
            authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
        } : {});
        return this.http.get('/api/secure/user', {headers: headers});
    }

    logout(): void {
        this.http.post('logout', {})
            .subscribe(data => console.log(data));
    }

}