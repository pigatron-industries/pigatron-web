import {OnInit} from "@angular/core";

import {AbstractDataService} from "./abstractdata.service";


export abstract class AbstractTableComponent<T> implements OnInit {

    rows: T[];

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

    delete(id: string): void {
        //TODO
    }
}
