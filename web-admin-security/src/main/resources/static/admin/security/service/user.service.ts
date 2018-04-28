import { Injectable, Inject } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from "rxjs";

import {User} from "./user";
import {AbstractDataService} from "web-admin-core/main";

@Injectable()
export class UserService extends AbstractDataService {

    constructor(@Inject(HttpClient) http: HttpClient) {
        super(http);
    }

    authenticate(credentials) {
        const headers = new HttpHeaders(credentials ? {
            authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
        } : {});
        return this.http.get('/api/secure/user', {headers: headers});
    }

    logout() {
        this.http.post('logout', {})
            .subscribe(data => console.log(data));
    }

    query() {
        //TODO paging sorting filtering
        return <Observable<Object[]>>this.http.get('api/security/user');
    }

    get(id: String) {
        return this.http.get('api/security/user/'+id);
    }

    save(user: User) {
        return this.http.post('api/security/user', user);
    }

}