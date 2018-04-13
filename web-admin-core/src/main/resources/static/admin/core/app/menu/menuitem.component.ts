import {Component, Input, OnInit, ViewChild, Inject} from '@angular/core';
import {Router} from '@angular/router';
import {MenuAction, MenuItem} from './menuitem';

@Component({
    selector: 'pg-menu-item',
    templateUrl: '/admin/core/app/menu/menuitem.component.html'
})
export class MenuItemComponent implements OnInit {
    @Input() menuitems: MenuItem[];
    @ViewChild('childMenu') public childMenu;

    constructor(@Inject(Router) private router: Router) {
    }

    ngOnInit() {
    }

    doAction(action: MenuAction) {
        console.log('doAction=' + action.action);
        if(action.type == 'open') {
            window.open(action.action);
        }
    }
}