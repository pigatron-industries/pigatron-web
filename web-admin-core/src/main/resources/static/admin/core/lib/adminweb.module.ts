import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {
    DateAdapter,
    MAT_NATIVE_DATE_FORMATS,
    MatButtonModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatMenuModule,
    MatNativeDateModule,
    MatSlideToggleModule,
    MatTooltipModule
} from '@angular/material';
import {FlexLayoutModule} from "@angular/flex-layout";
import {NgxDatatableModule} from '@swimlane/ngx-datatable';

import {XhrInterceptor} from "../app/httpinterceptor";
import {AppService} from "../app/app.service";
import {APP_DATE_FORMATS, AppDateAdapter} from "./dateadapter";


@NgModule({
    imports: [],
    providers: [
        { provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true },
        { provide: DateAdapter, useClass: AppDateAdapter },
        { provide: MAT_NATIVE_DATE_FORMATS, useValue: APP_DATE_FORMATS },
        AppService
    ],
    declarations: [],
    bootstrap:    [],
    exports: [
        CommonModule,
        RouterModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        FlexLayoutModule,
        MatFormFieldModule,
        MatInputModule,
        MatButtonModule,
        MatIconModule,
        MatTooltipModule,
        MatMenuModule,
        MatSlideToggleModule,
        MatDatepickerModule,
        MatNativeDateModule,
        NgxDatatableModule
    ]
})
export class AdminWebModule { }
