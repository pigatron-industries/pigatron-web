import {bootstrap} from "@angular/platform-browser-dynamic";
import {PublicAppComponent} from "./app/app.component";
import {APP_ROUTER_PROVIDERS} from "./app/app.routes";

export {DynamicHTMLDirective} from "./directives/dynamichtml.directive";


bootstrap(PublicAppComponent, [APP_ROUTER_PROVIDERS])
    .catch(err => console.error(err));

