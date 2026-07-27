import { Component, inject } from '@angular/core';
import { SHARED_IMPORTS } from '../shared/shared-imports';
import { KullaniciService } from '../Service/kullanici.service';
import { SiparisService } from '../Service/siparis.service';
import { ConfirmationService, MessageService } from 'primeng/api';

@Component({
  selector: 'app-kurye-ayarlari',
  standalone: true,
  imports: [SHARED_IMPORTS],
   providers: [ConfirmationService, MessageService],
  templateUrl: './kurye-ayarlari.component.html',
  styleUrl: './kurye-ayarlari.component.css'
})
export class KuryeAyarlariComponent {

private kullaniciService = inject(KullaniciService);
private siparisService = inject(SiparisService);
private confirmationService = inject(ConfirmationService);
private messageService = inject(MessageService);

hesap: any= '';

siparisler: any[] = [];

toplam: number = 0.0;

ngOnInit(){
   this.kullaniciGetir();
    this.kullaniciIdSiparisGetir();
}

kullaniciGetir(){
  this.kullaniciService.kullaniciGetir().subscribe(data=> this.hesap = data)
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

  kullaniciGuncelleOnay(event: Event) {
    this.confirmationService.confirm({
      target: event.target as EventTarget,
      message: 'Kullanıcı güncellensin mi?',
      icon: 'pi pi-exclamation-triangle',
      acceptLabel: 'Evet',
      rejectLabel: 'Hayır',
      accept: () => this.kullaniciGuncelle()
    });
  }

}
