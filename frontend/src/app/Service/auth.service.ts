import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BaseService } from '../core/services/base.service';

@Injectable({ providedIn: 'root' })
export class AuthService extends BaseService {
  protected baseUrl = '/auth';

  login(kullaniciAdi: string, sifre: string): Observable<any> {
    return this.post<any>('login', { kullaniciAdi, sifre });
  }

  
  tokenKaydet(cevap: any): void {
    localStorage.setItem('accessToken', cevap.accessToken);
    localStorage.setItem('refreshToken', cevap.refreshToken);
    localStorage.setItem('kullaniciId', cevap.kullaniciId);
  }

  logout(): void {
    localStorage.removeItem('accessToken');
    localStorage.removeItem('refreshToken');
    localStorage.removeItem('kullaniciId');
  }
}