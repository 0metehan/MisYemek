import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BaseService } from '../core/services/base.service';

    @Injectable({providedIn: 'root'})
  export class SiparisService extends BaseService {
  protected baseUrl = '/Siparisler';

  sepetGetir(): Observable<any[]> {
  return this.get<any[]>(`Sepet/${this.kullaniciId}`);
  }

  kullaniciIdSiparisGetir(): Observable<any[]> {
  return this.get<any[]>(`Getir/${this.kullaniciId}`);
  }
  
  sepetEkle(siparis: any): Observable<any>{
    return this.post<any>('Kaydet', siparis)
  }

  sepetSil(siparisId: number): Observable<any[]>{
    return this.delete<any[]>(`Sil/${siparisId}`)
  }

  sepetOde(): Observable<any[]>{
    return this.put<any[]>(`Sepet/Ode/${this.kullaniciId}`, {})
  }

  firmaIdSiparisGetir(firmaId: number | string): Observable<any[]>{
    return this.get<any[]>(`FirmaGetir/${firmaId}`)
  }

  sepetOnayla(siparisId: number): Observable<any>{
    return this.put<any>(`Sepet/Onayla/${siparisId}`,{})
  }

  sepetReddet(siparisId: number): Observable<any>{
    return this.put<any>(`Sepet/Reddet/${siparisId}`, {})
  }

  kuryeSiparis(): Observable<any[]>{
    return this.get<any[]>(`Kurye/Siparis`)
  }

  kuryeSiparisOnayla(firmaId: number , grupNo: number ): Observable<any>{
    return this.put<any>(`Kurye/TeslimEdildi/${firmaId}/${grupNo}` , {})
  }

  kuryeSiparisReddet(firmaId: number , grupNo: number): Observable<any>{
    return this.put<any>(`Kurye/Reddet/${firmaId}/${grupNo}` , {})
  } 

  sepetTakip(): Observable<any[]>{
    return this.get<any[]>(`${this.kullaniciId}`)
  }

  sepetTakipFirma(firmaId: number): Observable<any[]>{
    return this.get<any[]>(`Firma/SiparisTakip/${firmaId}`)
  }

  firmaTeslimSayac(firmaId: string , yil: number , ay: number): Observable<any>{
    return this.get<any>(`TeslimEdildiSayac/${firmaId}/${yil}/${ay}`)
  }

  firmaIptalSayac(firmaId: string , yil: number , ay: number): Observable<any>{
    return this.get<any>(`IptalSayac/${firmaId}/${yil}/${ay}`)
  }

  yildizSay(firmaId: string): Observable <any>{
    return this.get<any>(`Firma/YildizSayisi/${firmaId}`)
  }

  yildizEkle(firmaId: number , grupNo: number , yildizSayisi: number): Observable<any>{
    return this.put<any>(`Firma/YildizEkle/${firmaId}/${grupNo}/${yildizSayisi}`,{})
  }

}