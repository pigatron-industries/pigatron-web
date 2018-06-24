import {OnInit} from "@angular/core";
import {forkJoin} from 'rxjs';

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
        forkJoin(
            this.selected.map(entity => this.dataService.delete(entity.id))
        ).subscribe(() => {
            this.selected = [];
            this.load();
        });
    }
}
