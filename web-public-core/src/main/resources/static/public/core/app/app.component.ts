import { Component, forwardRef, Inject } from "@angular/core";
import { Routes, Router } from "@angular/router";

import { routes } from './app.routes';

@Component({
    selector: 'pg-public-app',
    templateUrl: '/public/core/app/app.component.html'
})
export class PublicAppComponent {

    private routes: Routes;

    constructor(@Inject(forwardRef(() => Router)) private router: Router) {
        this.loadModules();
    }

    /**
     * Get modules from pigatron namespace and load them.
     */
    loadModules() {
        this.routes = routes;
        let pigatron = window["pigatron"];
        for(let moduleName in pigatron) {
            if(pigatron.hasOwnProperty(moduleName)) {
                this.loadModule(pigatron[moduleName]);
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
