import {Component, Inject} from "@angular/core";
import {Router} from '@angular/router';

import {UserService} from "../users/user.service";


@Component({
    selector: 'pg-login',
    templateUrl: '/admin/security/login/login.component.html'
})
export class LoginComponent {

    credentials = {username: '', password: ''};

    constructor(@Inject(UserService) private userService: UserService,
                @Inject(Router) private router: Router) {
    }

    login() {
        this.userService.authenticate(this.credentials, () => {
            this.router.navigateByUrl('/');
        });
        return false;
    }

}
