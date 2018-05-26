import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';

import {UserService} from "../service/user.service";
import {AdminWebModule} from "web-admin-core/main";
import {UserComponent} from "./user.component";


@NgModule({
    imports: [
        AdminWebModule,
        RouterModule.forChild([{ path: '', component: UserComponent }]),
    ],
    providers: [ UserService ],
    declarations: [ UserComponent ],
    bootstrap:    [ UserComponent ]
})
export class UserModule { }
