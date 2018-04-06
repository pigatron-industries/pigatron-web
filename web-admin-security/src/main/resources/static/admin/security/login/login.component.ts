import {Component, Inject} from "@angular/core";

import {UserService} from "../users/user.service";


@Component({
    selector: 'pg-login',
    templateUrl: '/admin/security/login/login.component.html'
})
export class LoginComponent {

    credentials = {username: '', password: ''};

    constructor(@Inject(UserService) private userService: UserService) {
    }

    login() {
        this.userService.authenticate(this.credentials, undefined);
    }

}
