import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideAnimations } from '@angular/platform-browser/animations';
import { provideHttpClient, withInterceptors, HttpInterceptorFn } from '@angular/common/http';
import { routes } from './app.routes';

const tokenEkleyici: HttpInterceptorFn = (req, next) => { //:HttpInterceptorFn — Tip. "Bu değişken bir interceptor fonksiyonudur"
  const token = localStorage.getItem('accessToken');      //Interceptor http isteklerini getirip götüren fonksiyon
  if (token) {                                            //req --> giden istek   // next--> sıradaki durak 
    req = req.clone({ setHeaders: { Authorization: `Bearer ${token}` } });
  }
  return next(req);
};

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideAnimations(),
    provideHttpClient(withInterceptors([tokenEkleyici]))
  ]
};