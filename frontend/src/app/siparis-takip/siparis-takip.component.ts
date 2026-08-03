import { Component, inject } from '@angular/core';
import { SHARED_IMPORTS } from '../shared/shared-imports';
import { SiparisService } from '../Service/siparis.service';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-siparis-takip',
  standalone: true,
  imports: [SHARED_IMPORTS],
  templateUrl: './siparis-takip.component.html',
  styleUrl: './siparis-takip.component.css'
})
export class SiparisTakipComponent {

  private siparisService = inject(SiparisService)

  takip: any[] = [];
  yildiz: any[] = [];


  ngOnInit() {
    this.sepetTakip();
  }

  sepetTakip() {
    this.siparisService.sepetTakip().subscribe(data => this.takip = this.grupla(data));
  }

  private grupla(data: any[]): any[] {
    const gruplar: { [anahtar: string]: any } = {};
    for (const s of data) {
      const anahtar = s[5] + '-' + s[4];
      if (!gruplar[anahtar]) {
        gruplar[anahtar] = {
          siparisId: s[0],
          firmaId: s[5],
          grupNo: s[4],
          firmaAd: s[6],
          siparisDurumu: s[3],
          yildizSayisi: s[7],
          urunler: []
        };
      }
      gruplar[anahtar].urunler.push({ urun: s[1], adet: s[2] });
    }
    return Object.values(gruplar);
  }

  durumAdimlari: MenuItem[] = [
    { label: 'Hazırlanıyor' },
    { label: 'Yolda' },
    { label: 'Teslim Edildi' }
  ];

  durumIndex(durum: string): number {
    switch (durum) {
      case 'HAZIRLANIYOR': return 0;
      case 'YOLDA': return 1;
      case 'TESLIM_EDILDI': return 2;
      default: return 0;
    }
  }

  yildizPuan(s: any, yildiz: number) {
    this.siparisService.yildizEkle(s.firmaId, s.grupNo, yildiz).subscribe(() => this.sepetTakip());
  }
}
