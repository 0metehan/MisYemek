package com.example.misyemek.controller;

import com.example.misyemek.entity.Firma;
import com.example.misyemek.Service.FirmaService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Firma")
public class FirmaController {

    private final FirmaService service;

    public FirmaController(FirmaService service) {
        this.service = service;
    }

    @GetMapping("/Ara/{firmaAdi}")
    public List<Firma> firmaAdiGetir(@PathVariable String firmaAdi){
        return service.firmaAdiGetir(firmaAdi);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/Getir")
    public List<Firma> firmaFullGetir() {
        return service.firmaFullGetir();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{firmaId}")
    public Firma firmaGetir(@PathVariable Long firmaId){
        return service.firmaGetir(firmaId);
    }

    @PostMapping("/Kaydet")
    public Firma firmaEkle(@Valid @RequestBody Firma yeniFirma) {
        return service.firmaEkle(yeniFirma);
    }

    @PutMapping("/{firmaId}")
    public Firma firmaGuncelle(@PathVariable Long firmaId, @Valid @RequestBody Firma guncelUrun){
        return service.firmaGuncelle(firmaId, guncelUrun);
    }

    @DeleteMapping("/Sil/{firmaId}")
    public void firmaSil (@PathVariable Long firmaId){
        service.firmaSil(firmaId);
    }

    @GetMapping("/YildizaGoreSirala/{kullaniciId}")
    public List<Object[]> yildizaGoreSirala (@PathVariable Long kullaniciId){
        return service.yildizaGoreSirala(kullaniciId);
    }
}