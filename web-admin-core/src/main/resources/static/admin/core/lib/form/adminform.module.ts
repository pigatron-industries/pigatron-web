import {NgModule} from '@angular/core';
import {FormComponent} from "./form.component";
import {AdminWebModule} from "../adminweb.module";


@NgModule({
    imports: [ AdminWebModule ],
    providers: [],
    declarations: [ FormComponent ],
    bootstrap:    [],
    exports: [ AdminWebModule, FormComponent ]
})
export class AdminFormModule { }
