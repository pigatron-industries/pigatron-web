import {Component, Input, OnInit} from "@angular/core";
import {FormGroup} from "@angular/forms";

@Component({
    selector: 'pg-admin-form',
    templateUrl: '/admin/core/lib/form/form.component.html'
})
export class FormComponent implements OnInit {

    @Input()
    title : string;

    @Input()
    form : FormGroup;

    @Input()
    backRoute : string;

    ngOnInit(): void {
    }

}
