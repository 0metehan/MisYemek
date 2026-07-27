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
    this.siparisService.kuryeSiparis().subscribe(data => this.sepet = data)
  }

  kuryeSiprisOnay(siparisId: number) {
    this.siparisService.kuryeSiparisOnayla(siparisId).subscribe(() => {
      this.acikIndex = null;
      this.kuryeSiparis();
    })
  }

  kuryeSiparisReddet(siparisId: number){
    this.siparisService.kuryeSiparisReddet(siparisId).subscribe(() => {
      this.acikIndex = null;
      this.kuryeSiparis();
    })
  }

   
}
