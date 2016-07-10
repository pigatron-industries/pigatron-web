import {Component} from "@angular/core";
import {ROUTER_DIRECTIVES} from "@angular/router";
import {MD_TABS_DIRECTIVES} from "@angular2-material/tabs";


@Component({
    selector: 'pg-links',
    templateUrl: '/public/core/app/links/links.component.html',
    directives: [MD_TABS_DIRECTIVES, ROUTER_DIRECTIVES],
    providers: []
})
export class LinksComponent {
}