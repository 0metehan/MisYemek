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

  takip: any[]=[];

  ngOnInit(){
  this.sepetTakip();
}

  sepetTakip(){
  this.siparisService.sepetTakip().subscribe(data => {
    this.takip = data.filter((s: any) => s.siparisDurumu !== 'SEPETTE');
  });
}

  durumAdimlari: MenuItem[] = [
  { label: 'Hazırlanıyor' },
  { label: 'Yolda' },
  { label: 'Teslim Edildi' }
];

  durumIndex(durum: string): number {
  switch (durum) {
    case 'HAZIRLANIYOR':   return 0;
    case 'YOLDA':          return 1;
    case 'TESLIM_EDILDI':  return 2;
    default:               return 0;
  }
}
}
