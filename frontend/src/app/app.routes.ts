import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { YemekComponent } from './yemek/yemek.component';
import { HesapComponent } from './hesap/hesap.component';
import { SepetComponent } from './sepet/sepet.component';
import { FirmaSayfasiComponent } from './firma-sayfasi/firma-sayfasi.component';
import { FirmaUrunDuzenlemeComponent } from './firma-urun-duzenleme/firma-urun-duzenleme.component';
import { FirmaAyarlarComponent } from './firma-ayarlar/firma-ayarlar.component';
import { FirmaSiparisComponent } from './firma-siparis/firma-siparis.component';
import { KuryeAyarlariComponent } from './kurye-ayarlari/kurye-ayarlari.component';
import { TeslimatComponent } from './teslimat/teslimat.component';
import { SiparisTakipComponent } from './siparis-takip/siparis-takip.component';
import { FirmaSiparisTakipComponent } from './firma-siparis-takip/firma-siparis-takip.component';   

export const routes: Routes = [
    {path: '', redirectTo: 'login', pathMatch: 'full'},
    {path: 'login',component: LoginComponent},
    {path: 'yemek', component: YemekComponent},
    {path: 'hesap', component: HesapComponent},
    {path: 'sepet', component: SepetComponent},
    {path: 'firmaSayfasi/:firmaId', component: FirmaSayfasiComponent},
    {path: 'urunlerim/:firmaId', component: FirmaUrunDuzenlemeComponent},
    {path: 'firmaAyarlar/:firmaId', component: FirmaAyarlarComponent},
    {path: 'firmaSiparis/:firmaId' , component: FirmaSiparisComponent},
    {path: 'kuryeAyarlari' , component: KuryeAyarlariComponent},
    {path: 'teslimat', component: TeslimatComponent},
    {path: 'siparisTakip', component: SiparisTakipComponent},
    {path: 'firmaSiparisTakip/:firmaId' , component: FirmaSiparisTakipComponent},
];
