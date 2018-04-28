import 'zone.js/dist/zone';

// Angular
import "@angular/platform-browser";
import "@angular/platform-browser-dynamic";
import "@angular/core";
import "@angular/common";
import "@angular/common/http";
import "@angular/forms";
import "@angular/http";
import "@angular/router";
import "@angular/flex-layout";
import "@angular/material";
import "@swimlane/ngx-datatable";
import "rxjs";

// RxJS

// Angular Material
import "@angular/material";

// Other
//require("font-awesome/css/font-awesome.css");

export * from "@angular/core";
export {Routes, RouterModule, Router, ActivatedRoute} from '@angular/router';
export {CommonModule} from '@angular/common';
export {FormsModule, ReactiveFormsModule, FormControl, FormGroup, FormGroupDirective, NgForm,
        Validators} from '@angular/forms';
export {FlexLayoutModule} from "@angular/flex-layout";
export {MatFormFieldModule, MatInputModule, MatButtonModule} from '@angular/material';
export {ErrorStateMatcher} from '@angular/material/core';
export {HttpClientModule, HttpClient, HttpHeaders, HttpInterceptor,
        HttpRequest, HttpHandler, HTTP_INTERCEPTORS} from "@angular/common/http";
export * from "@swimlane/ngx-datatable";

//export * from "rxjs/Observable";