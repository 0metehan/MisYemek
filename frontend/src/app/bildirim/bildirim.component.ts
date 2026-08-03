import { Component, inject } from '@angular/core';
import { SHARED_IMPORTS } from '../shared/shared-imports';
import { BildirimService } from '../Service/bildirim.service';
import { interval } from 'rxjs';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-bildirim',
  standalone: true,
  imports: [SHARED_IMPORTS],
  templateUrl: './bildirim.component.html',
  styleUrl: './bildirim.component.css'
})
export class BildirimComponent {
  private bildirimService = inject(BildirimService)

  bildirimler: any[] = [];
  panelDurum: boolean = false;
 

  ngOnInit() {
    this.bildirimGetir();
    interval(15000).pipe(
    switchMap(() => this.bildirimService.bildirimGetir())
  ).subscribe(data => this.bildirimler = data);
  }

  panelAcKapa() {
    this.panelDurum = !this.panelDurum;
  }

  bildirimGetir() {
    this.bildirimService.bildirimGetir().subscribe(data => this.bildirimler = data)
  }
  bildirimSil(bildirimId: number){
  this.bildirimService.bildirimSil(bildirimId).subscribe(() =>
    this.bildirimService.bildirimGetir().subscribe(data => this.bildirimler = data)
  );
}
}
