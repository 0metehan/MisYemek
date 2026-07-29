package com.example.misyemek.controller;


import com.example.misyemek.Service.UrunlerService;
import com.example.misyemek.entity.Urunler;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Urunler")
public class UrunlerController {
    private final UrunlerService service;

    public UrunlerController(UrunlerService service) {
        this.service = service;
    }

    @GetMapping("/Getir")
    public List<Urunler> UrunFullGetir(){
        return service.UrunFullGetir();
    }

    @GetMapping("/{urunId}")
    public Urunler urunGetir(@PathVariable Integer urunId){
        return service.urunGetir(urunId);
    }

    @PostMapping("/Kaydet")
    public Urunler UrunEkle(@Valid @RequestBody Urunler yeniUrunler){
        return service.UrunEkle(yeniUrunler);
    }

    @PutMapping("/{urunId}")
    public Urunler urunGuncelle(@PathVariable Integer urunId, @Valid @RequestBody Urunler guncelUrun){
        return service.urunGuncelle(urunId, guncelUrun);
    }

    @DeleteMapping("/Sil/{urunId}")
    public void urunSil(@PathVariable Integer urunId) {
        service.urunSil(urunId);
    }

    @GetMapping("/Turu/{urunTuru}")
    public List<Urunler> urunTuruGetir(@PathVariable String urunTuru){
        return service.urunTuruGetir(urunTuru);
    }

}
