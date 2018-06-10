import {Observable} from "rxjs";
import {map} from "rxjs/operators"
import {HttpClient} from '@angular/common/http';


export abstract class AbstractDataService<T> {

    constructor(protected http: HttpClient, protected basePath: string) {
    }

    public query(): Observable<T[]> {
        //TODO paging sorting filtering
        return <Observable<T[]>>this.http.get(this.basePath)
            .pipe(
                map((data: T[]) => {
                    return data; //TODO call convert for each item in array
                })
            );
    };

    public get(id: string): Observable<T> {
        return <Observable<T>>this.http.get(this.basePath+'/'+id)
            .pipe(
                map((data: T) => {
                    return this.convert(data);
                })
            );
    }

    public save(data: T): Observable<T> {
        return <Observable<T>>this.http.post(this.basePath, data)
            .pipe(
                map((data: T) => {
                    return this.convert(data);
                })
            );
    };

    public delete(id: string): any {
        return this.http.delete(this.basePath+'/'+id);
    }

    protected convert(data: any): T {
        for (let key in data) {
            // Convert dates to JS dates
            if(key.indexOf("Date") >= 0) {
                data[key] = new Date(data[key]);
            }
        }
        return data;
    }
}