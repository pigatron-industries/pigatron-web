import {Component} from "@angular/core";
import {ROUTER_DIRECTIVES, Router, RouterConfig} from "@angular/router";
import {HTTP_PROVIDERS} from "@angular/http";
import {routes as coreRoutes} from "./app.routes";
import {LinksComponent} from "./links/links.component";


@Component({
    selector: 'pg-public-app',
    templateUrl: '/public/core/app/app.component.html',
    directives: [ROUTER_DIRECTIVES, LinksComponent],
    providers: [HTTP_PROVIDERS]
})
export class PublicAppComponent {

    private routes: RouterConfig;

    constructor(private router: Router) {
        this.loadModules();
    }

    /**
     * Get modules from pigatron namespace and load them.
     */
    loadModules() {
        this.routes = coreRoutes;

        for(var moduleName in window.pigatron) {
            if(window.pigatron.hasOwnProperty(moduleName)) {
                this.loadModule(window.pigatron[moduleName]);
            }
        }

        // add loaded routes to router
        this.router.resetConfig(this.routes);
    }

    /**
     * Load a single module.
     * @param module The module to load.
     */
    loadModule(module) {
        if(module.routes) {
            this.routes = this.routes.concat(module.routes);
        }
    }

}
