package com.example.misyemek.controller;
import com.example.misyemek.Service.FirmaUrunService;
import com.example.misyemek.entity.FirmaUrun;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/firmaUrun")
public class FirmaUrunController {
    private final FirmaUrunService service;

    public FirmaUrunController(FirmaUrunService service) {
        this.service = service;
    }

    @GetMapping("/getir")
    public List<FirmaUrun> urunFiyatFullGetir(){
        return service.urunFiyatFullGetir();
    }

    @GetMapping("/{id}")
    public FirmaUrun firmaUrunGetir(@PathVariable Long id){
        return service.firmaUrunGetir(id);
    }

    @PostMapping("/kaydet")  // FirmaUrun entity yerine dto olsun
    public FirmaUrun urunFiyatEkle(@Valid @RequestBody  FirmaUrun yeniUrunFirma){
        return service.urunFiyatEkle(yeniUrunFirma);
    }
    @PutMapping("/{id}")
    public FirmaUrun gunceleFirmaUrun (@PathVariable Long id, @Valid @RequestBody FirmaUrun guncelFirmaUrun){
        return service.gunceleFirmaUrun(id , guncelFirmaUrun);
    }

    @DeleteMapping("/{id}")
    public void firmaUrunSil(@PathVariable Long id){
        service.firmaUrunSil(id);
    }

    @GetMapping("/firmaUrunAylıkKazanç/{firmaId}/{yil}/{ay}")
    public BigDecimal firmaUrunAylikKazanc(@PathVariable Long firmaId, @PathVariable int yil, @PathVariable int ay){
        return service.firmaUrunAylikKazanc(firmaId , yil, ay);
    }
}
