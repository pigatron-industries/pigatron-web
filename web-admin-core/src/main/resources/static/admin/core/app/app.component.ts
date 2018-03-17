import { Component, Inject, forwardRef } from "@angular/core";
import { Routes, Router } from "@angular/router";

import { routes } from './app.routes';


@Component({
    selector: 'pg-admin-app',
    templateUrl: '/public/core/app/app.component.html'
})
export class AdminAppComponent {

    private routes: Routes;

    constructor(@Inject(forwardRef(() => Router)) private router: Router) {
        this.loadPgModules();
    }

    /**
     * Get modules from pigatron namespace and load them.
     */
    loadPgModules() {
        this.routes = routes;
        let pigatron = window["pigatron"];
        for(let moduleName in pigatron) {
            if(pigatron.hasOwnProperty(moduleName)) {
                this.loadPgModule(pigatron[moduleName], moduleName);
            }
        }

        // add loaded routes to router
        this.router.resetConfig(this.routes);
    }

    /**
     * Load a single module.
     * @param module The module to load.
     */
    loadPgModule(module, moduleName) {
        if(module.routes) {
            console.log("Loading module " + moduleName);
            this.loadRoutes(module.routes);
        }
    }

    loadRoutes(routes) {
        this.routes = this.routes.concat(routes);
    }

}
