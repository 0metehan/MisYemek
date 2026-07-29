import { Component,inject } from '@angular/core';
import { SHARED_IMPORTS } from '../shared/shared-imports';
import { KullaniciService } from '../Service/kullanici.service';

@Component({
  selector: 'app-kayit-ekrani',
  standalone: true,
  imports: [SHARED_IMPORTS],
  templateUrl: './kayit-ekrani.component.html',
  styleUrl: './kayit-ekrani.component.css'
})
export class KayitEkraniComponent {
  private kullaniciService = inject(KullaniciService)

 username: string = '';
  password: string = '';
  TelNo: string = '';
  message: string = '';
  kullaniciRol: string = ''

  kullaniciEkle(){
  this.kullaniciService.kullaniciEkle(this.username, this.password, this.TelNo, this.kullaniciRol).subscribe({
    next: () => {
      this.username = '';
      this.password = '';
      this.TelNo = '';
      this.kullaniciRol = '';
      this.message = 'Kayıt Başarılı';
    },
    error: () => {
      this.message = 'Kayıt başarısız Alanlar Boş Olamaz ';
    }
  });
}
}
