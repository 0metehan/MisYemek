package com.example.misyemek.controller;

import com.example.misyemek.Service.AdresService;
import com.example.misyemek.entity.Adres;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Adres")
public class AdresController {

    private final AdresService service;

    public AdresController(AdresService service) {
        this.service = service;
    }

    @GetMapping("/Getir")
    public List<Adres> adresGetir(){
        return service.adresGetir();
    }

    @PostMapping("/Kaydet")
    public Adres adresKaydet(@Valid @RequestBody Adres yeniAdres){
        return service.adresKaydet(yeniAdres);
    }

    @PutMapping("/{adresId}")
    public Adres adresGuncelle(@PathVariable Long adresId, @Valid @RequestBody Adres guncelAdres){
        return service.adresGuncelle(adresId, guncelAdres);
    }

    @DeleteMapping("/Sil/{adresId}")
    public void adresSil(@PathVariable Long adresId ){
        service.adresSil(adresId);
    }

    @GetMapping("/enYakinFirma/{kullaniciId}")
    public List<Object[]> enYakinFirma(@PathVariable Long kullaniciId){
        return service.enYakinFirma(kullaniciId);
    }

    @GetMapping("/urunListele/{kullaniciId}/{urunId}")
    public List<Object[]> urunListele(@PathVariable Long kullaniciId , @PathVariable Long urunId){
        return service.urunListele(kullaniciId , urunId );
    }
}
