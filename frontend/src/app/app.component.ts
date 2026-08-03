import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { SHARED_IMPORTS } from './shared/shared-imports'
import { FirmaSahibiService } from './Service/firma-sahibi.service';
import { AuthService } from './Service/auth.service';
import { KullaniciService } from './Service/kullanici.service';
import { BildirimComponent } from './bildirim/bildirim.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [SHARED_IMPORTS ,BildirimComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'

})
export class AppComponent {
  title = 'MisYemek';

  constructor(public router: Router) { }

  private authService = inject(AuthService);
  private firmaSahibiService = inject(FirmaSahibiService);
  private kullaniciService = inject(KullaniciService);
  

  firmaMenuAcik = false;
  firmaSahip: any = null;
  kurye = false;
  kuryeMenuAcik = false;

 kuryeAyarlarinaGit() {
  this.kuryeMenuAcik = false;
  this.router.navigate(['/kuryeAyarlari']);
 }

 teslimatlarimaGit() {
  this.kuryeMenuAcik = false;
  this.router.navigate(['/teslimat']);
 }

  ngOnInit() {
  this.firmaSahibiGetir();
  this.kullaniciKurye();
  }

  firmaSahibiGetir() {
  this.firmaSahibiService.firmaSahibiGetir().subscribe(data => this.firmaSahip = data);
  }

  logout() {
    this.authService.logout();
    window.location.href = '/login';
  }

  urunlerimeGit() {
    this.firmaMenuAcik = false;
    this.router.navigate(['/urunlerim', this.firmaSahip.firmaId.firmaId]);
  }

  firmaAyarlarinaGit() {
    this.firmaMenuAcik = false;
    this.router.navigate(['/firmaAyarlar', this.firmaSahip.firmaId.firmaId]);
  }

  firmaSiparislerineGit(){
    this.firmaMenuAcik = false;
    this.router.navigate(['/firmaSiparis', this.firmaSahip.firmaId.firmaId]); 
  }

  firmaSiparisTakip(){
    this.firmaMenuAcik = false;
    this.router.navigate(['/firmaSiparisTakip', this.firmaSahip.firmaId.firmaId]); 
  }

  kullaniciKurye(){
    this.kullaniciService.kullaniciGetir().subscribe(data => this.kurye = data.kullaniciRol === 'KURYE');
  }

}
