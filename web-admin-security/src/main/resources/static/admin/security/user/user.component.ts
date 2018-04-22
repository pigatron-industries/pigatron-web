import {Component, Inject, OnInit} from "@angular/core";
import {Router} from '@angular/router';
import {FormGroup, FormControl, Validators} from "@angular/forms";

import {UserService} from "../service/user.service";
import {User} from "../service/user";


@Component({
    selector: 'pg-users',
    templateUrl: '/admin/security/user/user.component.html'
})
export class UserComponent implements OnInit {

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

    ngOnInit(): void {

    }

    save(): void {
        console.log(this.form.value);
        this.userService.saveUser(this.form.value)
            .subscribe((data) => {
                this.form.setValue(data);
            });
    }

}
