import {Component, Inject} from "@angular/core";
import {Router} from '@angular/router';
import {FormControl, FormGroup, FormGroupDirective, NgForm, Validators, ValidationErrors} from '@angular/forms';

import {UserService} from "../users/user.service";


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
                @Inject(Router) private router: Router) {
    }

    login() {
        this.userService.authenticate(this.form.value)
            .subscribe(() => {
                this.router.navigateByUrl('/');
            },
            () => {
                this.form.setErrors(["Invalid username and password"]);
            });
        return false;
    }

}
