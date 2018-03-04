// import {Injectable} from "@angular/core";
// import {Http, Response} from "@angular/http";
// import {Observable} from "rxjs/Rx";
// import {Page} from "./page";
//
//
// @Injectable()
// export class PageService {
//
//     private url = '/api/cms/content/page';
//
//     constructor(private http: Http) {
//     }
//
//     get(urlKey : String) : Observable<Page> {
//         return this.http.get(this.url + '?urlKey=' + urlKey)
//             .map(this.extractData)
//             .catch(this.handleError);
//     }
//
//     private extractData(res: Response) {
//         let body = res.json();
//         return body;
//     }
//
//     private handleError (error: any) {
//         let errMsg = (error.message) ? error.message :
//             error.status ? error.status + " - " + error.statusText : 'Server error';
//         console.error(errMsg);
//         return Observable.throw(errMsg);
//     }
// }