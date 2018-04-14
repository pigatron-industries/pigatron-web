import {Component, Inject} from "@angular/core";
import {Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';

import {UserService} from "../service/user.service";
import {AppService} from "web-admin-core/main";


@Component({
    selector: 'pg-login',
    templateUrl: '/admin/security/login/login.component.html'
})
export class LoginComponent {

    form = new FormGroup({
        username: new FormControl('', [
            Validators.required
        ]),
        password: new FormControl('', [
            Validators.required
        ])
    });

    constructor(@Inject(UserService) private userService: UserService,
                @Inject(Router) private router: Router,
                @Inject(AppService) private appService: AppService) {
    }

    login() {
        this.userService.authenticate(this.form.value)
            .subscribe(() => {
                this.appService.refresh();
                this.router.navigateByUrl('/');
            },
            () => {
                this.form.setErrors(["Invalid username and password"]);
            });
        return false;
    }

}
