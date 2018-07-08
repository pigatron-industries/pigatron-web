import {Routes} from '@angular/router';
import {ContentsModule} from "./contents/contents.module";
import {ContentModule} from './content/content.module';

export const routes: Routes = [
    {
        path: 'contents',
        loadChildren: () => {
            return ContentsModule;
        }
    },
    {
        path: 'content/:id',
        loadChildren: () => {
            return ContentModule;
        }
    },
    {
        path: 'content/new/:type',
        loadChildren: () => {
            return ContentModule;
        }
    }
];
