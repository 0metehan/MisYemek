import { Component, inject } from '@angular/core';
import { Router} from '@angular/router';
import { SHARED_IMPORTS } from '../shared/shared-imports';
import { AuthService } from '../Service/auth.service';
import { KullaniciService } from '../Service/kullanici.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [SHARED_IMPORTS],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  private router = inject(Router);
  private authService = inject(AuthService);
  private kullaniciService = inject(KullaniciService);

  username: string = '';
  password: string = '';
  TelNo: string = '';
  message: string = '';
  kullaniciRol: string = ''

  login() {
    this.authService.login(this.username, this.password).subscribe({

      next: (token) => {
        this.authService.tokenKaydet(token);
        window.location.href = '/yemek';
      },

      error: () => {
        this.message = 'Giriş başarısız. Lütfen bilgilerinizi kontrol edin.';
      }

    });
  }

kullaniciEkle(){
  this.router.navigate(['/KayitOl']);
}
}