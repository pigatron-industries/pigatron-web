import {Injectable} from '@angular/core';
import {HttpInterceptor, HttpRequest, HttpHandler} from "@angular/common/http";

@Injectable()
export class XhrInterceptor implements HttpInterceptor {

    intercept(req: HttpRequest<any>, next: HttpHandler) {
        const xhr = req.clone({
            // prevent browser from showing http basic auth popup
            headers: req.headers.set('X-Requested-With', 'XMLHttpRequest')
        });
        return next.handle(xhr);
    }
}