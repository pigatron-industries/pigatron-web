import {Component, Inject, OnInit} from "@angular/core";
import {ActivatedRoute} from '@angular/router';
import {FormGroup, FormControl, Validators} from "@angular/forms";

import {UserService} from "../service/user.service";
import {User} from "../service/user";
import {AbstractFormComponent} from "web-admin-core/main";


@Component({
    selector: 'pg-users',
    templateUrl: '/admin/security/user/user.component.html'
})
export class UserComponent extends AbstractFormComponent<User> {

    form = new FormGroup({
        username: new FormControl('', [
            Validators.required
        ]),
        password: new FormControl('', [
            Validators.required
        ]),
        //enabled: new FormControl('', [])
    });

    constructor(@Inject(UserService) userService: UserService,
                @Inject(ActivatedRoute) route: ActivatedRoute) {
        super(userService, route);
    }

    create(params): void {
        this.data = new User();
    };

}
