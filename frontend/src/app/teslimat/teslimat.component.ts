import { Component,inject } from '@angular/core';
import { SHARED_IMPORTS } from '../shared/shared-imports';
import { SiparisService } from '../Service/siparis.service';

@Component({
  selector: 'app-teslimat',
  standalone: true,
  imports: [SHARED_IMPORTS],
  templateUrl: './teslimat.component.html',
  styleUrl: './teslimat.component.css'
})
export class TeslimatComponent {

  private siparisService = inject(SiparisService)

  sepet: any[]= [] ;
  acikIndex: number | null = null;
  
   detayToggle(i: number){
    this.acikIndex = this.acikIndex === i ? null : i;   //kartlar için açılıp kapanma özelliği
  }

  ngOnInit(){
    this.kuryeSiparis();
  }
  
  kuryeSiparis(){
  this.siparisService.kuryeSiparis().subscribe(data => this.sepet = this.grupla(data))
}

private grupla(data: any[]): any[] {
  const gruplar: { [anahtar: string]: any } = {};
  for (const s of data) {
    const anahtar = s[11] + '-' + s[10];        
    if (!gruplar[anahtar]) {
      gruplar[anahtar] = {
        siparisId: s[0],
        firmaId: s[11], 
        grupNo: s[10],
        kullaniciAdi: s[3],
        mahalle: s[4], 
        ilce: s[5], 
        sehir: s[6],
        kullaniciTelNo: s[7],
        firmaAd: s[8], 
        firmaTelNo: s[9],
        urunler: []
      };
    }
    gruplar[anahtar].urunler.push({ siparisId: s[0], urun: s[1], adet: s[2] });
  }
  return Object.values(gruplar);
}

  kuryeSiprisOnay(firmaId: number , grupNo: number) {
    this.siparisService.kuryeSiparisOnayla(firmaId , grupNo).subscribe(() => {
      this.acikIndex = null;
      this.kuryeSiparis();
    })
  }

  kuryeSiparisReddet(firmaId: number , grupNo: number){
    this.siparisService.kuryeSiparisReddet(firmaId ,grupNo).subscribe(() => {
      this.acikIndex = null;
      this.kuryeSiparis();
    })
  }

   
}
