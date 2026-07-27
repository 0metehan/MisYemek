import { Component,inject } from '@angular/core';
import { SHARED_IMPORTS } from '../shared/shared-imports';
import { SiparisService } from '../Service/siparis.service';
import { ActivatedRoute } from '@angular/router';
import { ConfirmationService, MessageService } from 'primeng/api';

@Component({
  selector: 'app-firma-siparis',
  standalone: true,
  imports: [SHARED_IMPORTS],
  providers: [ConfirmationService, MessageService],
  templateUrl: './firma-siparis.component.html',
  styleUrl: './firma-siparis.component.css'
})
export class FirmaSiparisComponent {
private siparisService = inject(SiparisService);
private route = inject(ActivatedRoute);
private confirmationService = inject(ConfirmationService);
private messageService = inject(MessageService);

siparis: any[] =[];
firmaId = this.route.snapshot.paramMap.get('firmaId')!;


  ngOnInit(){
  this.siparisGetir();
  }

  siparisGetir(){
  this.siparisService.firmaIdSiparisGetir(this.firmaId).subscribe(data => this.siparis = data )
  }

  siparisRedet(siparisId: number): void {
    this.siparisService.sepetSil(siparisId).subscribe(() => {
      this.siparisGetir()
      this.messageService.add({ severity: 'success', summary: 'Sipariş Rededildi' })
    })
  }

  siparisOnayla(siparisId: number){
    this.siparisService.sepetOnayla(siparisId).subscribe(() =>{
      this.siparisGetir()
       this.messageService.add({ severity: 'success', summary: 'Sipariş Yola Çıktı' })
    })
  }

  siparisReddet(siparisId: number){
    this.siparisService.sepetReddet(siparisId).subscribe(() =>{
      this.siparisGetir()
       this.messageService.add({ severity: 'success', summary: 'Sipariş iptal' })
    })
  }


}
