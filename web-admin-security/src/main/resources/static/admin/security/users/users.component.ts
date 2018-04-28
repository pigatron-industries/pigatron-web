import {Component, Inject, OnInit} from "@angular/core";

import {UserService} from "../service/user.service";
import {User} from "../service/user";
import {AbstractTableComponent} from "web-admin-core/main";


@Component({
    selector: 'pg-users',
    templateUrl: '/admin/security/users/users.component.html'
})
export class UsersComponent extends AbstractTableComponent<User> {

    constructor(protected userService: UserService) {
        super(userService);
    }

}
