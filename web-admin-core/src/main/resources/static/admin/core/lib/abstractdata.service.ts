import {OnInit} from "@angular/core";
import {Observable} from "rxjs";

import { HttpClient, HttpHeaders } from '@angular/common/http';


export abstract class AbstractDataService {
    constructor(protected http: HttpClient) {}
    abstract query(): Observable<Object[]>;
    abstract get(id: string): Observable<Object>;
    abstract save(data: Object): Observable<Object>;
}