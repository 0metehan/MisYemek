package com.example.misyemek.controller;
import com.example.misyemek.Service.FirmaUrunService;
import com.example.misyemek.entity.FirmaUrun;
import com.example.misyemek.entity.Urunler;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/FirmaUrun")
public class FirmaUrunController {
    private final FirmaUrunService service;

    public FirmaUrunController(FirmaUrunService service) {
        this.service = service;
    }

    @GetMapping("/Getir")
    public List<FirmaUrun> urunFiyatFullGetir(){
        return service.urunFiyatFullGetir();
    }

    @GetMapping("/{firmaId}")
    public List<FirmaUrun> firmaUrunGetir(@PathVariable Long firmaId){
        return service.firmaUrunGetir(firmaId);
    }

    @PostMapping("/Kaydet")
    public FirmaUrun urunEkle(@Valid @RequestBody  FirmaUrun yeniUrunFirma){
        return service.urunEkle(yeniUrunFirma);
    }

    @PutMapping("/{id}")
    public FirmaUrun gunceleFirmaUrun (@PathVariable Long id, @Valid @RequestBody FirmaUrun guncelFirmaUrun){
        return service.gunceleFirmaUrun(id , guncelFirmaUrun);
    }

    @DeleteMapping("/Sil/{id}")
    public void firmaUrunSil(@PathVariable Long id){
        service.firmaUrunSil(id);
    }

    @GetMapping("/FirmaUrunAylikKazanc/{firmaId}/{yil}/{ay}")
    @PreAuthorize("hasRole('ADMIN')")
    public BigDecimal firmaUrunAylikKazanc(@PathVariable Long firmaId, @PathVariable int yil, @PathVariable int ay){
        return service.firmaUrunAylikKazanc(firmaId , yil, ay);
    }

    @GetMapping("/yemekListele")
    public List<Object[]> yemekListele (){
        return service.yemekListele();
    }

    @PostMapping("/FirmaUrunKaydet")
    public FirmaUrun firmaUrunEkle(@RequestParam Long firmaId, @RequestParam String urunAdi, @RequestParam BigDecimal fiyat){
        return service.firmaUrunEkle(firmaId, urunAdi, fiyat);
    }
}