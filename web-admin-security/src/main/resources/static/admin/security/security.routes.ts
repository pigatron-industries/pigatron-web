import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: 'login',
        loadChildren: () => {
            return window["pigatron"].admin_security.LoginModule;
        }
    }
];
