import {Observable} from "rxjs";
import {HttpClient} from '@angular/common/http';


export abstract class AbstractDataService<T> {

    constructor(protected http: HttpClient, protected basePath: string) {
    }

    query(): Observable<T[]> {
        //TODO paging sorting filtering
        return <Observable<T[]>>this.http.get(this.basePath);
    };

    get(id: string): Observable<T> {
        return <Observable<T>>this.http.get(this.basePath+'/'+id);
    }

    save(data: T): Observable<T> {
        return <Observable<T>>this.http.post(this.basePath, data);
    };

    delete(id: string): any {
        return this.http.delete(this.basePath+'/'+id);
    }
}