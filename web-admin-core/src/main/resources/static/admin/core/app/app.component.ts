import {Component, forwardRef, Inject, OnInit} from "@angular/core";
import {Router, Routes} from "@angular/router";

import {routes} from './app.routes';
import {MenuService} from "./menu/menu.service";
import {MenuItem} from "./menu/menuitem";


@Component({
    selector: 'pg-admin-app',
    templateUrl: '/admin/core/app/app.component.html'
})
export class AdminAppComponent implements OnInit {

    private routes: Routes;
    private menu : MenuItem;

    constructor(@Inject(Router) private router: Router,
                @Inject(MenuService) private menuService: MenuService) {
        this.loadPgModules();
    }

    ngOnInit() {
        this.loadMenu();
    }

    loadMenu() {
        this.menuService.getAdminMenus()
            .subscribe((data) => {
                this.menu = <MenuItem>data; //TODO put cast in service
                console.log(this.menu);
            });
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
