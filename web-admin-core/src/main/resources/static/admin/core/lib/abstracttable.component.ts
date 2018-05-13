import {OnInit} from "@angular/core";
import {Observable} from 'rxjs/Observable';
import  'rxjs/add/observable/forkJoin';

import {AbstractDataService} from "./abstractdata.service";


export interface Entity {
    id: string
}

export abstract class AbstractTableComponent<T extends Entity> implements OnInit {

    rows: T[];
    selected: T[] = [];

    constructor(protected dataService: AbstractDataService<T>) {
    }

    ngOnInit(): void {
        this.load();
    }

    load(): void {
        this.dataService.query()
            .subscribe((data) => {
                this.rows = data;
            });
    }

    deleteSelected(): void {
        Observable.forkJoin(
            this.selected.map(entity => this.dataService.delete(entity.id))
        ).subscribe(() => {
            this.load();
        });
    }
}
