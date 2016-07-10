import {RouterConfig} from "@angular/router";
import {ProductComponent} from "./product/product.component";

export const routes: RouterConfig = [
    { path: 'category/:urlKey', component: ProductComponent },
    { path: 'product/:urlKey', component: ProductComponent }
];
