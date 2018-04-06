import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AdminAppModule } from './app/app.module';
import './style/main.scss';

export { AdminWebModule } from './lib/adminweb.module';

platformBrowserDynamic().bootstrapModule(AdminAppModule);