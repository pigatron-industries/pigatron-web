import {OnInit} from "@angular/core";
import {ActivatedRoute} from '@angular/router';
import {FormGroup} from "@angular/forms";

import {AbstractDataService} from "./abstractdata.service";


export abstract class AbstractFormComponent<T> implements OnInit {

    data: T;
    form: FormGroup;

    constructor(protected dataService: AbstractDataService<T>,
                protected route: ActivatedRoute) {
    }

    ngOnInit(): void {
        this.route.params.subscribe(params => {
            if(params['id'] != 'new') {
                this.load(params['id']);
            } else {
                this.data = this.create();
            }
        });
    }

    load(id: string): void {
        this.dataService.get(id)
            .subscribe(data => {
                this.afterLoad(data);
            });
    }

    save(): void {
        Object.assign(this.data, this.form.value);
        this.dataService.save(this.data)
            .subscribe((data) => {
                this.afterLoad(data);
            }, (error) => {
                this.form.setErrors([error.error.message]);
            });
    }

    protected afterLoad(data: T) {
        this.data = data;
        this.form.patchValue(data);
        this.form.markAsPristine();
    }

    abstract create(): T;

}
