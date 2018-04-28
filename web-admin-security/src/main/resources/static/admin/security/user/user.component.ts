import {Component, Inject, OnInit} from "@angular/core";
import {Router, ActivatedRoute} from '@angular/router';
import {FormGroup, FormControl, Validators} from "@angular/forms";

import {UserService} from "../service/user.service";
import {User} from "../service/user";


@Component({
    selector: 'pg-users',
    templateUrl: '/admin/security/user/user.component.html'
})
export class UserComponent implements OnInit {

    user: User;

    form = new FormGroup({
        id: new FormControl(),
        username: new FormControl('', [
            Validators.required
        ]),
        password: new FormControl('', [
            Validators.required
        ]),
        //enabled: new FormControl('', [])
    });

    constructor(@Inject(UserService) private userService: UserService,
                @Inject(Router) private router: Router,
                @Inject(ActivatedRoute) private route: ActivatedRoute) {
    }

    ngOnInit(): void {
        this.route.params.subscribe(params => {
            if(params['id'] != 'new') {
                this.load(params['id']);
            } else {
                this.user = new User();
            }
        })
    }

    load(id: string): void {
        this.userService.get(id)
            .subscribe(data => {
                this.user = <User>data;
                this.form.patchValue(data);
            })
    }

    save(): void {
        Object.assign(this.user, this.form.value);
        this.userService.save(this.user)
            .subscribe((data) => {
                this.form.patchValue(data);
            });
    }

}
