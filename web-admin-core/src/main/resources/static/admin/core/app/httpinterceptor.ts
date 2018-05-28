import {Inject, Injectable} from '@angular/core';
import {Router} from '@angular/router'
import {HttpErrorResponse, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {tap} from 'rxjs/operators';

@Injectable()
export class XhrInterceptor implements HttpInterceptor {

    constructor(@Inject(Router) private router: Router) {
    }

    intercept(req: HttpRequest<any>, next: HttpHandler) {
        const request = req.clone({
            // prevent browser from showing http basic auth popup
            headers: req.headers.set('X-Requested-With', 'XMLHttpRequest')
        });
        return next.handle(request).pipe(
            tap(
            () => {},
            (err: any) => {
                if (err instanceof HttpErrorResponse) {
                    // forward to login page if unauthenticated
                    if(err.status == 401 || err.status == 403) {
                        this.router.navigateByUrl("login");
                    }
                }
            })
        );
    }
}