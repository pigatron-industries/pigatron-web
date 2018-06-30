import {Component, Inject} from "@angular/core";

import {UserService} from "../service/user.service";
import {User} from "../service/user";
import {AbstractTableComponent} from "web-admin-core/main";


@Component({
    selector: 'pg-users',
    templateUrl: '/admin/security/users/users.component.html'
})
export class UsersComponent extends AbstractTableComponent<User> {

    columns = [{
        prop: 'username',
        width: 100
    }, {
        prop: 'email',
        width: 100
    }];

    constructor(@Inject(UserService) userService: UserService) {
        super(userService);
    }

}
