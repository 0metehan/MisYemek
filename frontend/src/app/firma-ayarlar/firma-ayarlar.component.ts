import { Component, inject } from '@angular/core';
import { FirmaService } from '../Service/firma.service';
import { ActivatedRoute } from '@angular/router';
import { SHARED_IMPORTS } from '../shared/shared-imports';
import { ConfirmationService, MessageService } from 'primeng/api';

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

  firma: any = null;
  firmaId = this.route.snapshot.paramMap.get('firmaId')!;

  ngOnInit() {
    this.firmaSahibiGetir();
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
}