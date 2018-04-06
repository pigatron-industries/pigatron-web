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
import "rxjs";

// RxJS

// Angular Material
import "@angular/material";

// Other
//require("font-awesome/css/font-awesome.css");

export * from "@angular/core";
export {Routes, RouterModule, Router} from '@angular/router';
export {CommonModule} from '@angular/common';
export {FormsModule} from '@angular/forms';
export {FlexLayoutModule} from "@angular/flex-layout";
export {MatFormFieldModule, MatInputModule, MatButtonModule} from '@angular/material';
export {HttpClientModule, HttpClient, HttpHeaders, HttpInterceptor,
        HttpRequest, HttpHandler, HTTP_INTERCEPTORS} from "@angular/common/http";
//export * from "@angular/http";
//export * from "rxjs/Observable";