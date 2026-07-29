import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BaseService } from '../core/services/base.service';

@Injectable({ providedIn: 'root' })
export class KullaniciService extends BaseService {
  protected baseUrl = '/Kullanici'

  kullaniciGetir(): Observable<any> {
    return this.get<any>(`${this.kullaniciId}`)
  }

  kullaniciGuncelle(id: number, updatedData: any): Observable<any> {
    return this.put<any>(`${id}`, updatedData)
  }

  firmaGucelle(firmaId: number, updatedData: any): Observable<any> {
    return this.put<any>(`${firmaId}`, updatedData)
  }

  sifreGuncelle(id: number ,yeniSifre: string): Observable<any>{
    return this.put<any>(`${id}` , {kullaniciSifresi: yeniSifre})
  }

  kullaniciEkle(kullaniciAdi: string, password: string, TelNo: string ,kullaniciRol: string): Observable<any> {
  return this.post<any>(`Kaydet`, {
    kullaniciAdi: kullaniciAdi,
    kullaniciSifresi: password,
    kullaniciTelNo: TelNo,
    kullaniciRol : kullaniciRol,
  });
}
}