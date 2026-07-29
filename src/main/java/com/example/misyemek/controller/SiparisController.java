package com.example.misyemek.controller;

import com.example.misyemek.Service.SiparisService;
import com.example.misyemek.entity.Siparis;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/Siparisler")
public class SiparisController {

    private final SiparisService service;

    public SiparisController(SiparisService service) {
        this.service = service;
    }

    @GetMapping("/Getir/{kullaniciId}")
    public List<Object[]> kullaniciIdSiparisGetir(@PathVariable Long kullaniciId) {
        return service.kullaniciIdSiparisGetir(kullaniciId);
    }

    @GetMapping("/FirmaGetir/{firmaId}")
    public List<Object[]> firmaIdSiparisGetir(@PathVariable Long firmaId) {
        return service.firmaIdSiparisGetir(firmaId);
    }

    @GetMapping("/{kullaniciId}")
    public List<Siparis> siparisGetir(@PathVariable Long kullaniciId) {
        return service.siparisGetir(kullaniciId);
    }

    @PostMapping("/Kaydet")
    public Siparis siparisEkle(@Valid @RequestBody Siparis yeniSiparis) {
        return service.siparisEkle(yeniSiparis);
    }

    @DeleteMapping("/Sil/{siparisId}")
    public void siparisSil(@PathVariable Long siparisId) {
        service.siparisSil(siparisId);
    }

    @GetMapping("/ToplamHarcama/{firmaId}/{kullaniciId}")
    public BigDecimal toplamHarcama(@PathVariable Long kullaniciId, @PathVariable Long firmaId) {
        return service.toplamHarcama(kullaniciId, firmaId);
    }

    @GetMapping("/Ciro/{firmaId}")
    @PreAuthorize("hasRole('ADMIN')")
    public BigDecimal toplamCiro(@PathVariable Long firmaId) {
        return service.toplamCiro(firmaId);
    }

    @GetMapping("/Sepet/{kullaniciId}")
    public List<Siparis> sepetGetir(@PathVariable Long kullaniciId) {
        return service.sepetGetir(kullaniciId);
    }

    @PutMapping("/Sepet/Ode/{kullaniciId}")
    public List<Siparis> sepetGuncelle(@PathVariable Long kullaniciId) {
        return service.sepetGuncelle(kullaniciId);
    }

    @PutMapping("/Sepet/Onayla/{siparisId}")
    public Siparis sepetOnayla(@PathVariable Long siparisId) {
        return service.sepetOnayla(siparisId);
    }

    @PutMapping("/Sepet/Reddet/{siparisId}")
    public Siparis sepetReddet(@PathVariable Long siparisId) {
        return service.sepetReddet(siparisId);
    }

    @GetMapping("/Kurye/Siparis")
    public List<Object[]> kuryeSiparis() {
        return service.kuryeSiparis();
    }

    @PutMapping("/Kurye/TeslimEdildi/{siparisId}")
    public Siparis kuryeSiparisTeslimEdildi(@PathVariable Long siparisId) {
        return service.kuryeSiparisTeslimEdildi(siparisId);
    }

    @PutMapping("/Kurye/Reddet/{siparisId}")
    public Siparis kuryeSiparisReddet(@PathVariable Long siparisId) {
        return service.kuryeSiparisReddet(siparisId);
    }

    @GetMapping("/Firma/SiparisTakip/{firmaId}")
    public List<Object[]> firmaSiparisTakip(@PathVariable Long firmaId) {
        return service.firmaSiparisTakip(firmaId);
    }

    @GetMapping("/TeslimEdildiSayac/{firmaId}/{yil}/{ay}")
    public Long firmaTeslimSayac(@PathVariable Long firmaId, @PathVariable int yil, @PathVariable int ay) {
        return service.firmaTeslimSayac(firmaId, yil, ay);
    }

    @GetMapping("/IptalSayac/{firmaId}/{yil}/{ay}")
    public Long firmaIptalSayac(@PathVariable Long firmaId, @PathVariable int yil, @PathVariable int ay) {
        return service.firmaIptalSayac(firmaId, yil, ay);
    }
}