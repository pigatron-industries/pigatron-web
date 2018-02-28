import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import {PublicAppModule} from './app/app.module';
import './style/web-public-core.scss';

platformBrowserDynamic().bootstrapModule(PublicAppModule);
