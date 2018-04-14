import {NgModule}      from '@angular/core';
import {RouterModule} from '@angular/router';

import {routes} from './users.route';
import {UserService} from "../service/user.service";
import {AdminWebModule} from "web-admin-core/main";
import {UsersComponent} from "./users.component";


@NgModule({
    imports: [
        AdminWebModule,
        RouterModule.forChild(routes),
    ],
    providers: [ UserService ],
    declarations: [ UsersComponent ],
    bootstrap:    [ UsersComponent ]
})
export class UsersModule { }
