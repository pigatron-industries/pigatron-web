import { Injectable, Inject } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {User} from "./user";

const options = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService {

    authenticated : boolean = false;

    constructor(@Inject(HttpClient) private http: HttpClient) {
        //authenticate user when browser loads to check if they are already logged in
        //this.authenticate(undefined, undefined);
    }

    authenticate(credentials, callback) {
        const headers = new HttpHeaders(credentials ? {
            authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
        } : {});
        this.http.get('/api/security/user', {headers: headers})
            .subscribe(response => {
                this.authenticated = response['username'];
                return callback && callback();
            });
    }

    logout() {
        this.http.post('logout', {})
            .subscribe(data => console.log(data));
    }

}