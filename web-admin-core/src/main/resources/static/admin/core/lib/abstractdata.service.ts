import {Observable} from "rxjs";
import {HttpClient} from '@angular/common/http';


export abstract class AbstractDataService {

    constructor(protected http: HttpClient, protected basePath: string) {
    }

    query(): Observable<Object[]> {
        //TODO paging sorting filtering
        return <Observable<Object[]>>this.http.get(this.basePath);
    };

    get(id: string): Observable<Object> {
        return this.http.get(this.basePath+'/'+id);
    }

    save(data: Object): Observable<Object> {
        return this.http.post(this.basePath, data);
    };
}