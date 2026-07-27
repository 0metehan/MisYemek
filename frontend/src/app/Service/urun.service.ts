import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BaseService } from '../core/services/base.service';

@Injectable({providedIn: 'root'})
export class UrunService extends BaseService{
    protected baseUrl = '/Urunler'
}