import { Component, inject, OnInit } from '@angular/core';
import { AdresService } from '../Service/adres.service';
import { SHARED_IMPORTS } from '../shared/shared-imports';
import { RouterLink } from '@angular/router';
import { KullaniciService } from '../Service/kullanici.service';
import { FirmaUrunService } from '../Service/firma-urun.service';
import { FirmaService } from '../Service/firma.service';

@Component({
  selector: 'app-yemek',
  standalone: true,
  imports: [SHARED_IMPORTS, RouterLink],
  templateUrl: './yemek.component.html',
  styleUrl: './yemek.component.css'
})
export class YemekComponent implements OnInit {
  private adresService = inject(AdresService);
  private kullaniciService = inject(KullaniciService);
  private firmaUrunService = inject(FirmaUrunService);
  private firmaService = inject(FirmaService);

  yemek: any[] = [];
  hesap: any = null;
  secim: string = "tumu";
  filtreliYemek: any[] = [];
  urunler: any[] = [];
  seciliUrun: any = null;
  arama: string = ''
  firma: any[] = [];

  ngOnInit() {
    this.EnYakinAdres();
    this.kullaniciGetir();
    this.urunListele();
  }

  EnYakinAdres() {
    this.adresService.EnYakinAdres().subscribe(data => {
      this.yemek = data;
      this.adresFiltrele();
    });
  }

  kullaniciGetir() {
    this.kullaniciService.kullaniciGetir().subscribe(data => this.hesap = data);
  }

  adresFiltrele() {
    if (this.arama) {
      this.filtreliYemek = this.yemek.filter(y => y[0].toLowerCase().includes(this.arama.toLowerCase()));
      return;
    }
    this.filtreliYemek = this.yemek

    if (this.secim == "mahalle") {
      this.filtreliYemek = this.yemek.filter(y => y[4] === 'mahalle');
    }

    if (this.secim == 'ilce') {
      this.filtreliYemek = this.yemek.filter(y => y[4] === 'ilçe' || y[4] === 'mahalle');
    }
  }

  //ürünü listede getir
  urunListele() {
    this.firmaUrunService.urunListele().subscribe(data => this.urunler = data.map(u => ({ id: u[0], ad: u[1] })));
  }

  //2 filtreyi birlikte çalışması için kuruldu.
  urunFirmalari() {
    this.adresService.urunListesiFirma(this.seciliUrun).subscribe(data => {
      this.yemek = data;
      this.adresFiltrele();
    });
  }

  //filtreler çakışmaması için konuldu
  urunSecildi() {
    if (this.seciliUrun == null) {
      this.EnYakinAdres();
    } else {
      this.urunFirmalari();
    }
  }

  firmaGetir() {
    this.firmaService.firmaAra(this.arama).subscribe(data => this.firma = data);
  }

}