import {Component, Inject} from "@angular/core";
import {Router} from '@angular/router';

import {UserService} from "../service/user.service";


@Component({
    selector: 'pg-users',
    templateUrl: '/admin/security/users/users.component.html'
})
export class UsersComponent {

    constructor(@Inject(UserService) private userService: UserService,
                @Inject(Router) private router: Router) {
    }

}
