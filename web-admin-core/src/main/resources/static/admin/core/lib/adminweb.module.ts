import {NgModule}      from '@angular/core';
import {CommonModule} from '@angular/common';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {MatFormFieldModule, MatInputModule, MatButtonModule} from '@angular/material';
import {FlexLayoutModule} from "@angular/flex-layout";

import {XhrInterceptor} from "../app/httpinterceptor";


@NgModule({
    imports: [],
    providers: [{ provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true }],
    declarations: [],
    bootstrap:    [],
    exports: [
        CommonModule,
        FormsModule,
        HttpClientModule,
        FlexLayoutModule,
        MatFormFieldModule,
        MatInputModule,
        MatButtonModule
    ]
})
export class AdminWebModule { }
