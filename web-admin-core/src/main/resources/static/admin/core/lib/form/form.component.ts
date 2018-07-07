import {Component, Input, OnInit} from "@angular/core";

@Component({
    selector: 'pg-admin-form',
    templateUrl: '/admin/core/lib/form/form.component.html'
})
export class FormComponent implements OnInit {

    @Input()
    title;

    ngOnInit(): void {
    }

}
