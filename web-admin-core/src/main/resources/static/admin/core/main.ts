import {enableProdMode} from '@angular/core';
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import 'zone.js/dist/zone';

import {AdminAppModule} from './app/app.module';
import './style/main.scss';

export { AdminWebModule } from './lib/adminweb.module';
export { AppService } from './app/app.service';
export { AbstractDataService } from './lib/abstractdata.service';
export { AbstractFormComponent } from './lib/abstractform.component';
export { AbstractTableComponent } from './lib/abstracttable.component';

enableProdMode();
platformBrowserDynamic().bootstrapModule(AdminAppModule);



/************ Library Exports ************/

// Angular
export * from "@angular/core";
export {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
export {BrowserAnimationsModule} from '@angular/platform-browser/animations';
export {Routes, RouterModule, Router, ActivatedRoute} from '@angular/router';
export {CommonModule} from '@angular/common';
export {FormsModule, ReactiveFormsModule, FormControl, FormGroup, FormGroupDirective, NgForm,
    Validators, ControlValueAccessor, NG_VALUE_ACCESSOR} from '@angular/forms';
export {HttpClientModule, HttpClient, HttpHeaders, HttpInterceptor,
    HttpRequest, HttpHandler, HTTP_INTERCEPTORS} from "@angular/common/http";

// Angular Material
export {FlexLayoutModule} from "@angular/flex-layout";
export {MatFormFieldModule, MatInputModule, MatButtonModule} from '@angular/material';
export {ErrorStateMatcher} from '@angular/material/core';

// Other
export * from "@swimlane/ngx-datatable";
