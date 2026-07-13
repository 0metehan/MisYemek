package com.example.misyemek.controller;

import com.example.misyemek.Service.KullaniciService;

import com.example.misyemek.entity.Kullanici;

import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Kullanici")
public class KullaniciController {

    private final KullaniciService service;

    public KullaniciController(KullaniciService service){
        this.service=service;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/Getir")
    public List<Kullanici> kullaniciFullGetir(){
        return service.kullaniciFullGetir();
    }

    @PostMapping("/Kaydet")
    public Kullanici kullaniciEkle(@Valid @RequestBody Kullanici yeniKullanici){
        return service.kullaniciEkle(yeniKullanici);
    }

    @GetMapping("/{id}")
    public Kullanici kullaniciGetir(@PathVariable("id") Long id){
        return service.kullaniciGetir(id);
    }

    @PutMapping("/{id}")
    public Kullanici kullaniciGuncelle(@PathVariable("id") Long id,
                                       @Valid @RequestBody Kullanici guncelKullanici){
        return service.kullaniciGuncelle(id, guncelKullanici);
    }
    @DeleteMapping("/Sil/{id}")
    public void kullaniciSil(@PathVariable Long id){
        service.kullaniciSil(id);
    }
}
