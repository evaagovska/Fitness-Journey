import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HTTP_INTERCEPTORS } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable()
export class HttpRequestIntercepor implements HttpInterceptor{
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        req=req.clone({
            withCredentials:true
        });
        return next.handle(req)
    }
}
export const HttpInterceptorProviders=[
{provide: HTTP_INTERCEPTORS, useClass:HttpRequestIntercepor, multi:true}
]