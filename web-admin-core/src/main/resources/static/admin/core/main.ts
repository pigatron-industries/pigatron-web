import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AdminAppModule } from './app/app.module';
import './style/main.scss';

export { AdminWebModule } from './lib/adminweb.module';
export { AppService } from './app/app.service';
export { AbstractDataService } from './lib/abstractdata.service';
export { AbstractFormComponent } from './lib/abstractform.component';

platformBrowserDynamic().bootstrapModule(AdminAppModule);