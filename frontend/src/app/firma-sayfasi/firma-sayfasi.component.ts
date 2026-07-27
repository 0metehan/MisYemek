import { Component, inject, OnInit } from '@angular/core';
import { SHARED_IMPORTS } from '../shared/shared-imports';
import { ActivatedRoute } from '@angular/router';
import { FirmaUrunService } from '../Service/firma-urun.service';
import { SiparisService } from '../Service/siparis.service';
import { ConfirmationService, MessageService } from 'primeng/api';

@Component({
  selector: 'app-firma-sayfasi',
  standalone: true,
  imports: [SHARED_IMPORTS],
  providers: [ConfirmationService, MessageService],
  templateUrl: './firma-sayfasi.component.html',
  styleUrl: './firma-sayfasi.component.css'
})
export class FirmaSayfasiComponent implements OnInit {

  private route = inject(ActivatedRoute);
  private siparisService = inject(SiparisService);
  private firmaUrunService = inject(FirmaUrunService);
  private messageService = inject(MessageService);

  firmaId = this.route.snapshot.paramMap.get('firmaId')!;
  urunler: any[] = [];

  ngOnInit() {
    this.urunleriGetir();                         //buton olmadan sayfayı yüklemeye yarar
  }

  urunleriGetir() {
    this.firmaUrunService.firmaUrunGetir(this.firmaId)
      .subscribe(data => {
        data.forEach(u => u.adet = 1);
        this.urunler = data;
      });
  }

  sepetEkle(id: number, adet: number) {
    this.siparisService.sepetEkle({
      siparisDurumu: 'SEPETTE',
      kullaniciId: Number(localStorage.getItem('kullaniciId')),
      adet: adet,
      firmaUrun: { id: id }
    }).subscribe(() =>
      this.messageService.add({ severity: 'success', summary: 'Sepete Eklendi' })
    );
  }
}
