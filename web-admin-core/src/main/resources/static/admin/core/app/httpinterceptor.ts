import {Injectable, Inject} from '@angular/core';
import {Router} from '@angular/router'
import {HttpInterceptor, HttpRequest, HttpHandler, HttpErrorResponse} from "@angular/common/http";
import 'rxjs/add/operator/do';

@Injectable()
export class XhrInterceptor implements HttpInterceptor {

    constructor(@Inject(Router) private router: Router) {
    }

    intercept(req: HttpRequest<any>, next: HttpHandler) {
        const request = req.clone({
            // prevent browser from showing http basic auth popup
            headers: req.headers.set('X-Requested-With', 'XMLHttpRequest')
        });
        return next.handle(request).do(
            () => {},
            (err: any) => {
                if (err instanceof HttpErrorResponse) {
                    // forward to login page if unauthenticated
                    if(err.status == 401 || err.status == 403) {
                        this.router.navigateByUrl("login");
                    }
                }
            });
    }
}