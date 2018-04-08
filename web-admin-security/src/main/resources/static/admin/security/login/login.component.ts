import {Component, Inject} from "@angular/core";
import {Router} from '@angular/router';
import {FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from '@angular/forms';

import {UserService} from "../users/user.service";


@Component({
    selector: 'pg-login',
    templateUrl: '/admin/security/login/login.component.html'
})
export class LoginComponent {

    credentials = {username: '', password: ''};

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
        console.log(this.form);
        this.userService.authenticate(this.form.value, () => {
            this.router.navigateByUrl('/');
        });
        return false;
    }

}
