import {NgModule} from '@angular/core';
import {TableComponent} from "./table.component";
import {AdminWebModule} from "../adminweb.module";


@NgModule({
    imports: [ AdminWebModule ],
    providers: [],
    declarations: [ TableComponent ],
    bootstrap:    [],
    exports: [ AdminWebModule, TableComponent ]
})
export class AdminTableModule { }
