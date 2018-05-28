import {Injectable} from '@angular/core';
import {Subject} from 'rxjs';

@Injectable()
export class AppService {

    private refreshEventSource = new Subject<boolean>();

    refreshEvent$ = this.refreshEventSource.asObservable();

    refresh() {
        this.refreshEventSource.next(true);
    }

}
