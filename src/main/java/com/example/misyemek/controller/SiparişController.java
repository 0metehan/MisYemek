package com.example.misyemek.controller;

import com.example.misyemek.Service.SiparişService;
import com.example.misyemek.entity.Sipariş;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/siparisler")
public class SiparişController {

    private final SiparişService service;

    public SiparişController(SiparişService service) {
        this.service = service;
    }

    @GetMapping("/getir")
    public List<Sipariş> siparişFullGetir(){
        return service.siparişFullGetir();
    }

    @GetMapping("/{siparisId}")
    public Sipariş siparisGetir(@PathVariable Long siparisId){
        return service.siparişGetir(siparisId);
    }

    @PostMapping("/ekle")
    public Sipariş siparisEkle(@Valid @RequestBody Sipariş yeniSipariş){
        return service.siparişEkle(yeniSipariş);
    }

    @DeleteMapping("/{siparisId}")
    public void siparisSil(@PathVariable Long siparisId){
        service.siparisSil(siparisId);
    }

    @GetMapping("/toplamHarcama/{kullaniciId}/{firmaId}")
    public BigDecimal toplamHarcama (@PathVariable Long kullaniciId ,@PathVariable Long firmaId){
        return service.toplamHarcama(kullaniciId, firmaId);
    }

    @GetMapping("/ciro/{firmaId}")
    public BigDecimal toplamCiro (@PathVariable Long firmaId ){
        return service.toplamCiro(firmaId );
    }



}
