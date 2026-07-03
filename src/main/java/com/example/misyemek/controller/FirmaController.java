package com.example.misyemek.controller;

import com.example.misyemek.entity.Firma;
import com.example.misyemek.Service.FirmaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/firma")
public class FirmaController {

    private final FirmaService service;

    public FirmaController(FirmaService service) {
        this.service = service;
    }

    @GetMapping("/getir")
    public List<Firma> firmaFullGetir() {
        return service.firmaFullGetir();
    }

    @GetMapping("/{firmaId}")
    public Firma firmaGetir(@PathVariable Long firmaId){
        return service.firmaGetir(firmaId);
    }

    @PostMapping("/kaydet")
    public Firma firmaEkle(@Valid @RequestBody Firma yeniFirma) {
        return service.firmaEkle(yeniFirma);
    }

    @PutMapping("/{firmaId}")
    public Firma firmaGuncelle(@PathVariable Long firmaId, @Valid @RequestBody Firma guncelUrun){
        return service.firmaGuncelle(firmaId, guncelUrun);
    }

    @DeleteMapping("/sil/{firmaId}")
    public void firmaSil (@PathVariable Long firmaId){
        service.firmaSil(firmaId);
    }
}