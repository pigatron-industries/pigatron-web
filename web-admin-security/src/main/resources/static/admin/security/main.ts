import { Routes } from '@angular/router';
export { LoginModule } from "./login/login.module";
export { UsersModule } from "./users/users.module";
export { UserModule } from "./user/user.module";

export const routes: Routes = [
    {
        path: 'login',
        loadChildren: () => {
            return window["pigatron"].admin_security.LoginModule;
        }
    },
    {
        path: 'users',
        loadChildren: () => {
            return window["pigatron"].admin_security.UsersModule;
        }
    },
    {
        path: 'user/:id',
        loadChildren: () => {
            return window["pigatron"].admin_security.UserModule;
        }
    }
];
