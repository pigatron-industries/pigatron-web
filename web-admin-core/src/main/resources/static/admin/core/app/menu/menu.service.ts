import { Injectable, Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class MenuService {

    constructor(@Inject(HttpClient) private http: HttpClient) {
    }

    getAdminMenus() {
        return this.http.get('api/menu');
    }

}