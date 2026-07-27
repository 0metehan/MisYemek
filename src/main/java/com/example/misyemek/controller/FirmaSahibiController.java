package com.example.misyemek.controller;

import com.example.misyemek.Service.FirmaSahibiService;
import com.example.misyemek.entity.FirmaSahibi;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/FirmaSahibi")
public class FirmaSahibiController {
    private final FirmaSahibiService service;

    public FirmaSahibiController(FirmaSahibiService service) {
        this.service = service;
    }

    @GetMapping("/{kullaniciId}")
    public FirmaSahibi firmaSahibiGetir(@PathVariable Long kullaniciId){
        return service.firmaSahibiGetir(kullaniciId);
    }

}
