import { Component, inject, OnInit } from '@angular/core';
import { AdresService } from '../Service/adres.service';
import { SHARED_IMPORTS } from '../shared/shared-imports';
import { RouterLink } from '@angular/router';
import { KullaniciService } from '../Service/kullanici.service';
import { FirmaUrunService } from '../Service/firma-urun.service';
import { FirmaService } from '../Service/firma.service';
import { UrunService } from '../Service/urun.service';

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
  private urunService = inject(UrunService);
  
  yemek: any[] = [];
  hesap: any = null;
  secim: string = "tumu";
  filtreliYemek: any[] = [];
  urunler: any[] = [];
  seciliUrun: any = null;
  arama: string = '';
  firma: any[] = [];
  turListesi: any[] = [];
  seciliTur: string ='';
  turAdDuzeltme: any[] = [];
 

  ngOnInit() {
    this.EnYakinAdres();
    this.kullaniciGetir();
    this.urunListele();
    this.kategorileriYukle();
    
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

  turFirma(){
      this.firmaUrunService.turFirma(this.seciliTur).subscribe(data => {
      this.yemek = data;
      this.adresFiltrele();}
    )
  }

  turSecildi(tur: string) {
  this.seciliTur = tur;
  if (!this.seciliTur) {
    this.EnYakinAdres();      
  } else {
    this.turFirma();     
  }
}

kategorileriYukle() {
  this.urunService.hepsiniGetir().subscribe(data => {
    this.turListesi = [];
    for (const u of data) {
      if (u.urunTuru
          && u.urunTuru !== 'ICECEK'
          && u.urunTuru !== 'SOS'
          && !this.turListesi.includes(u.urunTuru)) {
        this.turListesi.push(u.urunTuru);
      }
    }
  });
}

turEtiketleri: { [key: string]: string } = {
  FASTFOOD: 'Fast Food',
  LAHMACUN: 'Lahmacun',
  PIDE: 'Pide',
  EV_YEMEGI: 'Ev Yemeği',
  MANTI: 'Mantı',
  DURUM: 'Dürüm',
  CORBA: 'Çorba',
  SALATA: 'Salata',
  KEBAP: 'Kebap',
  SOKAK_LEZZETI: 'Sokak Lezzetleri',
  TATLI: 'Tatlı',
  BALIK: 'Balık',
  MEZE: 'Meze',
}

yildizaGoreSirala(){
  this.firmaService.yildizaGoreSirala().subscribe(data => this.filtreliYemek = data)
}
}