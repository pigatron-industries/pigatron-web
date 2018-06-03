import {Routes} from '@angular/router';

import {PageModule} from "./page/page.module";


export const routes: Routes = [
    // {
    //     path: 'posts',
    //     loadChildren: () => {
    //         return window["pigatron"].public_cms.PageModule;
    //     }
    // },
    // {
    //     path: 'post',
    //     loadChildren: () => {
    //         return window["pigatron"].public_cms.PageModule;
    //     }
    // },
    {
        path: 'page',
        loadChildren: () => {
            return PageModule;
        }
    },
    {
        path: '',
        loadChildren: () => {
            return PageModule;
        }
    }
];
