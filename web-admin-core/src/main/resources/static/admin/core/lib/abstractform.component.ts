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
                this.data = data;
                this.form.patchValue(data);
            });
    }

    save(): void {
        console.log(this.data);
        Object.assign(this.data, this.form.value);
        this.dataService.save(this.data)
            .subscribe((data) => {
                this.form.patchValue(data);
                this.form.markAsPristine();
            }, (error) => {
                this.form.setErrors([error.error.message]);
            });
    }

    abstract create(): T;

}
