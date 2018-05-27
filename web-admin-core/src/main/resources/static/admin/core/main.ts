import {enableProdMode} from '@angular/core';
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';

import {AdminAppModule} from './app/app.module';
import './style/main.scss';

export { AdminWebModule } from './lib/adminweb.module';
export { AppService } from './app/app.service';
export { AbstractDataService } from './lib/abstractdata.service';
export { AbstractFormComponent } from './lib/abstractform.component';
export { AbstractTableComponent } from './lib/abstracttable.component';

enableProdMode();
platformBrowserDynamic().bootstrapModule(AdminAppModule);