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
    // public page: Page;
    //
    // private sub: any;
    //
    //
    // constructor(private router : Router,
    //             private route : ActivatedRoute,
    //             private pageService : PageService) {
    // }
    //
    ngOnInit() {
        this.loaded = true;
        // this.sub = this.route.params.subscribe(params => {
        //     this.load(params['urlKey']);
        // });
    }
    //
    // ngOnDestroy() {
    //     this.sub.unsubscribe();
    // }
    //
    // load(urlKey) {
    //     this.pageService.get(urlKey)
    //         .subscribe(page => {
    //             this.page = page;
    //             this.loaded = true;
    //         });
    // }

}
