import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BaseService } from '../core/services/base.service';

@Injectable({providedIn: 'root'})
export class FirmaSahibiService extends BaseService {

    protected baseUrl =`/FirmaSahibi`

    firmaSahibiGetir(): Observable<any>{
        return this.get<any>(`${this.kullaniciId}`)
    }
} 