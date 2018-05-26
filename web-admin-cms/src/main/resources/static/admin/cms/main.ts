import {Routes} from '@angular/router';

export {ContentsModule} from './contents/contents.module';
export {ContentModule} from './content/content.module';

export const routes: Routes = [
    {
        path: 'contents',
        loadChildren: () => {
            return window["pigatron"].admin_cms.ContentsModule;
        }
    },
    {
        path: 'page/:id',
        loadChildren: () => {
            return window["pigatron"].admin_cms.ContentModule;
        }
    },
    {
        path: 'post/:id',
        loadChildren: () => {
            return window["pigatron"].admin_cms.ContentModule;
        }
    }
];
