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
        path: 'page/:id',
        loadChildren: () => {
            return ContentModule;
        }
    },
    {
        path: 'post/:id',
        loadChildren: () => {
            return ContentModule;
        }
    }
];
