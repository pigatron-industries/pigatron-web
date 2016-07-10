import {bootstrap} from "@angular/platform-browser-dynamic";
import {PublicAppComponent} from "./app/app.component";
import {APP_ROUTER_PROVIDERS} from "./app/app.routes";


bootstrap(PublicAppComponent, [APP_ROUTER_PROVIDERS])
    .catch(err => console.error(err));

