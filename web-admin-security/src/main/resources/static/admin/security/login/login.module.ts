import {NgModule}      from '@angular/core';
import {RouterModule} from '@angular/router';

import {LoginComponent}   from './login.component';
import {routes} from './login.route';
import {UserService} from "../service/user.service";
import {AdminWebModule} from "web-admin-core/main";


@NgModule({
    imports: [
        AdminWebModule,
        RouterModule.forChild(routes),
    ],
    providers: [ UserService ],
    declarations: [ LoginComponent ],
    bootstrap:    [ LoginComponent ]
})
export class LoginModule { }
