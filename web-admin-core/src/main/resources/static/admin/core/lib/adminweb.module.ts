import {NgModule}      from '@angular/core';
import {CommonModule} from '@angular/common';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatFormFieldModule, MatInputModule, MatButtonModule} from '@angular/material';
import {FlexLayoutModule} from "@angular/flex-layout";
import {NgxDatatableModule} from '@swimlane/ngx-datatable';

import {XhrInterceptor} from "../app/httpinterceptor";
import {AppService} from "../app/app.service";


@NgModule({
    imports: [],
    providers: [
        { provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true },
        AppService
    ],
    declarations: [],
    bootstrap:    [],
    exports: [
        CommonModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        FlexLayoutModule,
        MatFormFieldModule,
        MatInputModule,
        MatButtonModule,
        NgxDatatableModule
    ]
})
export class AdminWebModule { }
