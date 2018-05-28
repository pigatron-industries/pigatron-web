import {Routes} from '@angular/router';
import {LoginModule} from "./login/login.module";
import {UsersModule} from "./users/users.module";
import {UserModule} from "./user/user.module";

export const routes: Routes = [
    {
        path: 'login',
        loadChildren: () => {
            return LoginModule;
        }
    },
    {
        path: 'users',
        loadChildren: () => {
            return UsersModule;
        }
    },
    {
        path: 'user/:id',
        loadChildren: () => {
            return UserModule;
        }
    }
];
