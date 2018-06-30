import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';

import {UserService} from "../service/user.service";
import {AdminTableModule} from "web-admin-core/main";
import {UsersComponent} from "./users.component";


@NgModule({
    imports: [
        AdminTableModule,
        RouterModule.forChild([{ path: '', component: UsersComponent }]),
    ],
    providers: [ UserService ],
    declarations: [ UsersComponent ],
    bootstrap:    [ UsersComponent ]
})
export class UsersModule { }
