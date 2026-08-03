import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BaseService } from '../core/services/base.service';

@Injectable({ providedIn: 'root' })
export class BildirimService extends BaseService{
     protected baseUrl = '/Bildirim'

     bildirimGetir(): Observable<any>{
        return this.get<any>(`${this.kullaniciId}`)
     }

     bildirimSil(bildirimId: number): Observable<any>{
        return this.delete<any>(`${bildirimId}`)
     }
}