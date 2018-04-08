import { Injectable, Inject } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class UserService {

    constructor(@Inject(HttpClient) private http: HttpClient) {
        //authenticate user when browser loads to check if they are already logged in
        //this.authenticate(undefined, undefined);
    }

    authenticate(credentials) {
        const headers = new HttpHeaders(credentials ? {
            authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
        } : {});
        return this.http.get('/api/security/user', {headers: headers});
    }

    logout() {
        this.http.post('logout', {})
            .subscribe(data => console.log(data));
    }

}