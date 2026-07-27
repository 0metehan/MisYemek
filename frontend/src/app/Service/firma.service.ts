import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BaseService } from '../core/services/base.service';

@Injectable({ providedIn: 'root' })
export class FirmaService extends BaseService {
  protected baseUrl = '/Firma';

  firmaAra(firmaAdi: string): Observable<any[]> {
    return this.get<any[]>(`Ara/${firmaAdi}`);
  }

  firmaGuncelle(firmaId: number, veri: any): Observable<any> {
    return this.put<any>(`${firmaId}`, veri);
  }

  firmaIdAra(firmaId: number | string): Observable<any>{
    return this.get<any>(`${firmaId}`)
  }
}
