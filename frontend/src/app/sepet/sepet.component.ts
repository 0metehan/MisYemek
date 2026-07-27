import { Component, inject } from '@angular/core';
import { SHARED_IMPORTS } from '../shared/shared-imports'
import { SiparisService } from '../Service/siparis.service';
import { ConfirmationService, MessageService } from 'primeng/api';

@Component({
  selector: 'app-sepet',
  standalone: true,
  imports: [SHARED_IMPORTS],
  providers: [ConfirmationService, MessageService],
  templateUrl: './sepet.component.html',
  styleUrl: './sepet.component.css'
})
export class SepetComponent {

  private siparisService = inject(SiparisService);
  private confirmationService = inject(ConfirmationService);
  private messageService = inject(MessageService);

  sepet: any[] = [];

  toplam: number = 0.0;

  ngOnInit() {
    this.sepetGetir();
  }

  sepetGetir() {
    this.siparisService.sepetGetir().subscribe(data => {
      this.sepet = data;
      this.toplam = data.reduce((toplam, s) => toplam + s.firmaUrun?.fiyat * s.adet, 0)
});
  }
  
  odemeYap() {
    this.siparisService.sepetOde().subscribe(() => {
      this.sepetGetir()
      this.messageService.add({ severity: 'success', summary: 'Sipariş Alındı' })
    })
  }

  sepetSil(siparisId: number): void {
    this.siparisService.sepetSil(siparisId).subscribe(() => {
      this.sepetGetir()
      this.messageService.add({ severity: 'success', summary: 'Ürün Silindi' })
    })
  }

  odemeYapOnay(event: Event) {
    this.confirmationService.confirm({
      target: event.target as EventTarget,
      message: 'Ödeme Tamamlansın mı?',
      icon: 'pi pi-exclamation-triangle',
      acceptLabel: 'Evet',
      rejectLabel: 'Hayır',
      accept: () => this.odemeYap()
    });
  }

}