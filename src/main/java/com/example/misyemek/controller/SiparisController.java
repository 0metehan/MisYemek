package com.example.misyemek.controller;

import com.example.misyemek.Service.SiparisService;
import com.example.misyemek.entity.Siparis;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/Siparisler")
public class SiparisController {

    private final SiparisService service;

    public SiparisController(SiparisService service) {
        this.service = service;
    }

    @GetMapping("/Getir")
    public List<Siparis> siparisFullGetir(){
        return service.siparisFullGetir();
    }

    @GetMapping("/{siparisId}")
    public Siparis siparisGetir(@PathVariable Long siparisId){
        return service.siparisGetir(siparisId);
    }

    @PostMapping("/Kaydet")
    public Siparis siparisEkle(@Valid @RequestBody Siparis yeniSiparis){
        return service.siparisEkle(yeniSiparis);
    }

    @DeleteMapping("/Sil/{siparisId}")
    public void siparisSil(@PathVariable Long siparisId){
        service.siparisSil(siparisId);
    }

    @GetMapping("/ToplamHarcama/{firmaId}/{kullaniciId}")
    public BigDecimal toplamHarcama (@PathVariable Long kullaniciId ,@PathVariable Long firmaId){
        return service.toplamHarcama(kullaniciId, firmaId);
    }

    @GetMapping("/Ciro/{firmaId}")
    @PreAuthorize("hasRole('ADMIN')")
    public BigDecimal toplamCiro (@PathVariable Long firmaId ){
        return service.toplamCiro(firmaId );
    }

}
