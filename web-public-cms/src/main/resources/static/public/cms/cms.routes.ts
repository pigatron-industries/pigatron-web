import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: 'page',
        loadChildren: () => {
            return window["pigatron"].public_cms.PageModule;
        }
    },
    {
        path: 'posts',
        loadChildren: () => {
            return window["pigatron"].public_cms.PageModule;
        }
    },
    {
        path: 'post',
        loadChildren: () => {
            return window["pigatron"].public_cms.PageModule;
        }
    }
];
