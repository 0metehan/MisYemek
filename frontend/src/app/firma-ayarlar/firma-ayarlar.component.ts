import { Component, inject } from '@angular/core';
import { FirmaService } from '../Service/firma.service';
import { ActivatedRoute } from '@angular/router';
import { SHARED_IMPORTS } from '../shared/shared-imports';
import { ConfirmationService, MessageService } from 'primeng/api';
import { FirmaUrunService } from '../Service/firma-urun.service';
import { SiparisService } from '../Service/siparis.service';

@Component({
  selector: 'app-firma-ayarlar',
  standalone: true,
  imports: [SHARED_IMPORTS],
  providers: [ConfirmationService, MessageService],
  templateUrl: './firma-ayarlar.component.html',
  styleUrl: './firma-ayarlar.component.css'
})
export class FirmaAyarlarComponent {

  private route = inject(ActivatedRoute);
  private firmaService = inject(FirmaService);
  private confirmationService = inject(ConfirmationService);
  private messageService = inject(MessageService);
  private firmaUrunService = inject(FirmaUrunService);
  private siparisService = inject(SiparisService)

  firma: any = null;
  firmaId = this.route.snapshot.paramMap.get('firmaId')!;
  yil: any = '';
  ay: any = '';
  kazanc: any = null;
  seciliTarih: Date = new Date(); 
  teslimSayac: any = null;
  iptal: any = null;

  ngOnInit() {
    this.firmaSahibiGetir();
    this.aySecildi();
    this.firmaTeslimSayac();
    this.firmaIptalSayac();
  }

  firmaSahibiGetir() {
    this.firmaService.firmaIdAra(this.firmaId).subscribe(data => this.firma = data)
  }

  firmaGuncelle() {
    this.firmaService.firmaGuncelle(this.firma.firmaId, this.firma)
      .subscribe(() => {
        this.firmaSahibiGetir();
        this.messageService.add({ severity: 'success', summary: 'Firma güncellendi' });
      });
  }

  firmaGuncelleOnay(event: Event) {
    this.confirmationService.confirm({
      target: event.target as EventTarget,
      message: 'Firma güncellensin mi?',
      icon: 'pi pi-exclamation-triangle',
      acceptLabel: 'Evet',
      rejectLabel: 'Hayır',
      accept: () => this.firmaGuncelle()
    });
  }

  firmaUrunAylikKazanc(){
    this.firmaUrunService.firmaUrunAylikKazanc(this.firmaId ,this.yil ,this.ay).subscribe(data => this.kazanc = data)
  }
  
  aySecildi() {
  this.yil = this.seciliTarih.getFullYear();   // 2026
  this.ay  = this.seciliTarih.getMonth() + 1;  // Temmuz → 7
  this.firmaUrunAylikKazanc();
  this.firmaTeslimSayac();
  this.firmaIptalSayac();
}
firmaTeslimSayac(){
  this.siparisService.firmaTeslimSayac(this.firmaId ,this.yil , this.ay).subscribe(data => this.teslimSayac = data)
}
firmaIptalSayac(){
  this.siparisService.firmaIptalSayac(this.firmaId ,this.yil , this.ay).subscribe(data => this.iptal = data)
}
}