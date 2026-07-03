package com.example.misyemek.controller;

import com.example.misyemek.Service.KullanıcıService;
import com.example.misyemek.entity.Kullanıcı;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kullanici")
public class KullanıcıController {

    private final KullanıcıService service;

    public KullanıcıController(KullanıcıService service){
        this.service=service;
    }

    @GetMapping("/getir")
    public List<Kullanıcı> kullanıcıFullGetir(){
        return service.kullanıcıFullGetir();
    }

    @PostMapping("/kaydet")
    public Kullanıcı kullanıcıEkle(@Valid @RequestBody Kullanıcı yeniKullanıcı){
        return service.kullanıcıEkle(yeniKullanıcı);
    }

    @GetMapping("/{id}")
    public Kullanıcı kullanıcıGetir(@PathVariable("id") Long id){
        return service.kullanıcıGetir(id);
    }

    @PutMapping("/{id}")
    public Kullanıcı kullaniciGuncelle(@PathVariable("id") Long id,
                                       @Valid @RequestBody Kullanıcı guncelKullanici){
        return service.kullaniciGuncelle(id, guncelKullanici);
    }
    @DeleteMapping("/{id}")
    public void kullaniciSil(@PathVariable Long id){
        service.kullaniciSil(id);
    }
}
