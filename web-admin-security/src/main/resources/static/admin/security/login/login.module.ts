import { NgModule }      from '@angular/core';
import { CommonModule } from '@angular/common';
//import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';

import { LoginComponent }   from './login.component';
import { routes } from './login.route';


@NgModule({
    imports: [
        CommonModule,
        //BrowserAnimationsModule,
        RouterModule.forChild(routes)
    ],
    declarations: [ LoginComponent ],
    bootstrap:    [ LoginComponent ]
})
export class LoginModule { }
