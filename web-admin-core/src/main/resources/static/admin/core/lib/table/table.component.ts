import {Component, Input, OnInit, TemplateRef, ViewChild} from "@angular/core";

@Component({
    selector: 'pg-admin-table',
    templateUrl: '/admin/core/lib/table/table.component.html'
})
export class TableComponent implements OnInit {

    @Input()
    title;

    @Input()
    columns;

    @Input()
    rows;

    @Input()
    selected;

    @Input()
    editRoute;

    @ViewChild('actionColumnTemplate')
    actionColumnTemplate: TemplateRef<any>;

    allColumns = [];


    ngOnInit(): void {
        this.allColumns.push({
            checkboxable: true,
            headerCheckboxable: true,
            width: 30,
            resizeable: false,
            draggable: false,
            canAutoResize: false,
            sortable: false
        });
        this.allColumns.push({
            cellTemplate: this.actionColumnTemplate,
            width: 30,
            resizeable: false,
            draggable: false,
            canAutoResize: false,
            sortable: false
        });
        this.allColumns = this.allColumns.concat(this.columns);
    }

}
