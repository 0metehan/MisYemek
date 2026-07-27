import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BaseService } from '../core/services/base.service';

@Injectable({ providedIn: 'root' })
export class FirmaUrunService extends BaseService {
  protected baseUrl = '/FirmaUrun';

  firmaUrunGetir(firmaId: number | string): Observable<any[]> {
    return this.get<any[]>(`${firmaId}`);
  }

  fiyatDuzenle(firmaUrunId: number, veri: any): Observable<any> {
    return this.put<any>(`${firmaUrunId}`, veri);
  }

  firmaUrunEkle(veri: any[]): Observable<any[]> {
    return this.post<any[]>(`Kaydet`, veri)
  }

  urunListele(): Observable<any[]> {
    return this.get<any[]>(`yemekListele`)
  }

  firmaUrunSil(firmaUrunId: number): Observable<any[]>{
    return this.delete<any[]>(`Sil/${firmaUrunId}`)
  }

    firmaUrunKaydet(firmaId: number | string, urunAdi: string, fiyat: number): Observable<any> {
    return this.post<any>(
      `FirmaUrunKaydet?firmaId=${firmaId}&urunAdi=${encodeURIComponent(urunAdi)}&fiyat=${fiyat}`,
      null
    );
  }//encodeURIComponent(urunAdi) türkçe karakterler için hata engelleme

}
