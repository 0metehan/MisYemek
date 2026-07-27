import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BaseService } from '../core/services/base.service';

@Injectable({ providedIn: 'root' })
export class AdresService extends BaseService {
   protected baseUrl = '/Adres'

   EnYakinAdres(): Observable<any[]> {
      return this.get<any[]>(`enYakinFirma/${this.kullaniciId}`)
   }

   urunListesiFirma(urunId: number): Observable<any[]> {
      return this.get<any[]>(`urunListele/${this.kullaniciId}/${urunId}`)
   }
}