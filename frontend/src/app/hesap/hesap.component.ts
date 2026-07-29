import { Component, inject } from '@angular/core';
import { SHARED_IMPORTS } from '../shared/shared-imports'
import { KullaniciService } from '../Service/kullanici.service';
import { ConfirmationService, MessageService } from 'primeng/api';
import { SiparisService } from '../Service/siparis.service';

@Component({
  selector: 'app-hesap',
  standalone: true,
  imports: [SHARED_IMPORTS],
  providers: [ConfirmationService, MessageService],
  templateUrl: './hesap.component.html',
  styleUrl: './hesap.component.css'
})
export class HesapComponent {
  private kullaniciService = inject(KullaniciService);
  private confirmationService = inject(ConfirmationService);
  private messageService = inject(MessageService);
  private siparisService = inject(SiparisService);

  hesap: any = null;

  siparisler: any[] = [];

  toplam: number = 0.0;

  yeniSifre: string = '';

  ngOnInit() {
    this.kullaniciGetir();
    this.kullaniciIdSiparisGetir();
  }

kullaniciGuncelleOnay(event: Event, inplace?: any) {
  this.confirmationService.confirm({
    target: event.target as EventTarget,
    message: 'Kullanıcı güncellensin mi?',
    icon: 'pi pi-exclamation-triangle',
    acceptLabel: 'Evet',
    rejectLabel: 'Hayır',
    accept: () => {
      this.kullaniciGuncelle();
      inplace?.deactivate();
    },
    reject: () => inplace?.deactivate()
  });
}

  kullaniciGetir() {
  this.kullaniciService.kullaniciGetir().subscribe(data => {
    this.hesap = data;
    if (!this.hesap.adres) {
      this.hesap.adres = { sehir: '', ilce: '', mahalle: '' };
    }
  });
}

  kullaniciGuncelle() {
    this.kullaniciService.kullaniciGuncelle(this.hesap.id, this.hesap).subscribe(() => {
      this.kullaniciGetir();
      this.messageService.add({ severity: 'success', summary: 'Kullanıcı güncellendi' });
    });
  }


  kullaniciIdSiparisGetir() {
    this.siparisService.kullaniciIdSiparisGetir().subscribe(data => {
      this.siparisler = data;
      this.toplam = data.reduce((t, a) => t + a[5] * a[3] * 0.5, 0);
    });
  }

  sifreGuncelle(){
    return this.kullaniciService.sifreGuncelle(this.hesap.id ,this.yeniSifre).subscribe(()=> {
      this.yeniSifre=''
      this.messageService.add({ severity: 'success', summary: 'Kullanıcı güncellendi' })  }  )}

kullaniciSifreOnay(event: Event, inplace?: any) {
  this.confirmationService.confirm({
    target: event.target as EventTarget,
    message: 'Kullanıcı Şifresi Güncellensin mi?',
    icon: 'pi pi-exclamation-triangle',
    acceptLabel: 'Evet',
    rejectLabel: 'Hayır',
    accept: () => { this.sifreGuncelle(); inplace?.deactivate(); },
    reject: () => inplace?.deactivate()
  });
}
  
}