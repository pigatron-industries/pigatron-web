import {Component, Inject, OnInit} from "@angular/core";
import {Router} from '@angular/router';

import {UserService} from "../service/user.service";
import {User} from "../service/user";


@Component({
    selector: 'pg-users',
    templateUrl: '/admin/security/users/users.component.html'
})
export class UsersComponent implements OnInit {

    rows: User[];

    constructor(@Inject(UserService) private userService: UserService,
                @Inject(Router) private router: Router) {
    }

    ngOnInit(): void {
        this.loadData();
    }

    loadData(): void {
        this.userService.query()
            .subscribe((data) => {
                this.rows = <User[]>data;
            });
    }

    deleteUser(): void {
        //TODO
    }

}
