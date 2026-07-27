import { Component,inject } from '@angular/core';
import { SHARED_IMPORTS } from '../shared/shared-imports';
import { SiparisService } from '../Service/siparis.service';
import { ActivatedRoute } from '@angular/router';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-firma-siparis-takip',
  standalone: true,
  imports: [SHARED_IMPORTS],
  templateUrl: './firma-siparis-takip.component.html',
  styleUrl: './firma-siparis-takip.component.css'
})
export class FirmaSiparisTakipComponent {

  private siparisService = inject(SiparisService)
  private route = inject(ActivatedRoute)

  takip: any[] = [];

  ngOnInit(){
    const firmaId = Number(this.route.snapshot.paramMap.get('firmaId'));
    this.firmaSiparisTakip(firmaId);
  }

  firmaSiparisTakip(firmaId: number){
    return this.siparisService.sepetTakipFirma(firmaId).subscribe(data =>this.takip=data)
  }

  durumAdimlari: MenuItem[] = [
  { label: 'Yolda' },
  { label: 'Teslim Edildi' }
];

durumIndex(durum: string): number {
  switch (durum) {
    case 'YOLDA':          return 0;
    case 'TESLIM_EDILDI':  return 1;
    default:               return 0;
  }
}
}
