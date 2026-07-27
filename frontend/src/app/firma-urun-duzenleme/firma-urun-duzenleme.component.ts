import { Component, inject, OnInit } from '@angular/core';
import { SHARED_IMPORTS } from '../shared/shared-imports';
import { ActivatedRoute } from '@angular/router';
import { FirmaUrunService } from '../Service/firma-urun.service';
import { ConfirmationService, MessageService } from 'primeng/api';

@Component({
  selector: 'app-firma-urun-duzenleme',
  standalone: true,
  imports: [SHARED_IMPORTS],
  providers: [ConfirmationService, MessageService],
  templateUrl: './firma-urun-duzenleme.component.html',
  styleUrl: './firma-urun-duzenleme.component.css'
})
export class FirmaUrunDuzenlemeComponent implements OnInit {

  private route = inject(ActivatedRoute);
  private firmaUrunService = inject(FirmaUrunService);
  private messageService = inject(MessageService);
  private confirmationService = inject(ConfirmationService);


  firmaId = this.route.snapshot.paramMap.get('firmaId')!;
  urunler: any[] = [];
  secilenUrun: any = null;
  firmaUrunId: any = null;
  urunEkle: any = null;
  urunAdi: any = '';
  urunFiyat: any = null;


  ngOnInit() {
    this.urunleriGetir();
  }

  urunleriGetir() {
    this.firmaUrunService.firmaUrunGetir(this.firmaId)
      .subscribe(data => this.urunler = data);
  }

  fiyatDuzenle() {
    this.firmaUrunService.fiyatDuzenle(this.secilenUrun.id, this.secilenUrun)
      .subscribe(() => {
        this.urunleriGetir();
        this.messageService.add({ severity: 'success', summary: 'Ürün güncellendi' });
      });
  }

  firmaUrunSil(firmaUrunId: number): void {
    this.firmaUrunService.firmaUrunSil(firmaUrunId).subscribe(() => {
      this.urunleriGetir()
      this.messageService.add({ severity: 'success', summary: 'Ürün Silindi' })
    })
  }

  urunSilOnay(event: Event, firmaUrunId: number) {
    this.confirmationService.confirm({
      target: event.target as EventTarget,
      message: 'Ürün Silinsin mi?',
      icon: 'pi pi-exclamation-triangle',
      acceptLabel: 'Evet',
      rejectLabel: 'Hayır',
      accept: () => this.firmaUrunSil(firmaUrunId)
    });
  }

  firmaUrunKaydet() {
    this.firmaUrunService.firmaUrunKaydet(this.firmaId, this.urunAdi, this.urunFiyat).subscribe(() => {
      this.urunleriGetir();
      this.messageService.add({ severity: 'success', summary: 'Ürün eklendi' });
      this.urunAdi = '';
      this.urunFiyat = null;
    }
    )
  }
}
