import { Routes } from '@angular/router';
import { PageComponent } from "./content/page/page.component";

export const routes: Routes = [
    { path: 'page/:urlKey', component: PageComponent },
    { path: 'posts',        component: PageComponent },
    { path: 'post/:urlKey', component: PageComponent }
];
