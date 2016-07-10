import {RouterConfig} from "@angular/router";
import {PageComponent} from "./content/page/page.component.ts";

export const routes: RouterConfig = [
    { path: 'page/:urlKey', component: PageComponent },
    { path: 'posts',        component: PageComponent },
    { path: 'post/:urlKey', component: PageComponent }
];
