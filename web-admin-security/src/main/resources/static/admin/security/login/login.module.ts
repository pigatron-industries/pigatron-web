import {NgModule}      from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {MatFormFieldModule, MatInputModule, MatButtonModule} from '@angular/material';
import {FlexLayoutModule} from "@angular/flex-layout";

import {LoginComponent}   from './login.component';
import {routes} from './login.route';


@NgModule({
    imports: [
        CommonModule,
        RouterModule.forChild(routes),
        FlexLayoutModule,
        MatFormFieldModule,
        MatInputModule,
        MatButtonModule
    ],
    declarations: [ LoginComponent ],
    bootstrap:    [ LoginComponent ]
})
export class LoginModule { }
