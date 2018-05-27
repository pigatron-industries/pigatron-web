import 'zone.js/dist/zone';

// Angular
export * from "@angular/core";
export {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
export {BrowserAnimationsModule} from '@angular/platform-browser/animations';
export {Routes, RouterModule, Router, ActivatedRoute} from '@angular/router';
export {CommonModule} from '@angular/common';
export {FormsModule, ReactiveFormsModule, FormControl, FormGroup, FormGroupDirective, NgForm,
        Validators} from '@angular/forms';
export {HttpClientModule, HttpClient, HttpHeaders, HttpInterceptor,
        HttpRequest, HttpHandler, HTTP_INTERCEPTORS} from "@angular/common/http";

// Angular Material
export {FlexLayoutModule} from "@angular/flex-layout";
export {MatFormFieldModule, MatInputModule, MatButtonModule} from '@angular/material';
export {ErrorStateMatcher} from '@angular/material/core';

// Other
export * from "@swimlane/ngx-datatable";
