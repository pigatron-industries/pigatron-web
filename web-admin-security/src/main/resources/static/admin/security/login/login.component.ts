import {Component, OnInit} from "@angular/core";
import {Router, ActivatedRoute} from "@angular/router";
//import {PageService} from "./page.service.ts";
//import {Page} from "./page";
//import {DynamicHTMLDirective} from "pigatron/public/core/main";


@Component({
    selector: 'pg-login',
    templateUrl: '/admin/security/login/login.component.html'
})
export class LoginComponent implements OnInit {

    public loaded: boolean = false;

    ngOnInit() {
        this.loaded = true;
        // this.sub = this.route.params.subscribe(params => {
        //     this.load(params['urlKey']);
        // });
    }

    login() {
        console.log("login button pressed");
    }

}
