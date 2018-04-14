import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AdminAppModule } from './app/app.module';
import './style/main.scss';

export { AdminWebModule } from './lib/adminweb.module';
export { AppService } from './app/app.service';

platformBrowserDynamic().bootstrapModule(AdminAppModule);