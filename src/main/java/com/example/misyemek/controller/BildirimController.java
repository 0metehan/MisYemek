package com.example.misyemek.controller;

import com.example.misyemek.Service.BildirimService;
import com.example.misyemek.entity.Bildirim;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Bildirim")
public class BildirimController {

    private final BildirimService service;

    public BildirimController(BildirimService service) {
        this.service = service;
    }

    @GetMapping("/{kullaniciId}")
    public List<Bildirim> kullaniciBildirimGetir(@PathVariable("kullaniciId") Long kullaniciId){
        return service.kullaniciBildirimGetir(kullaniciId);
    }

    @DeleteMapping("/{bildirimId}")
    public void bildirimSil(@PathVariable("bildirimId") Long bildirimId){
        service.bildirimSil(bildirimId);
    }
}
