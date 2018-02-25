// import {Injectable} from "@angular/core";
// import {Http, Response} from "@angular/http";
// import {Observable} from "rxjs/Rx";
//
//
// @Injectable()
// export class SettingsService {
//
//     private url = '/api/settings';
//
//     constructor(private http: Http) {
//     }
//
//     get(id : String) : Observable<any> {
//         return this.http.get(this.url + '?id=' + id)
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