package com.example.misyemek.Service;

import com.example.misyemek.entity.Urunler;
import com.example.misyemek.repository.UrunlerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrunlerService {

    private final UrunlerRepository repository;

    public UrunlerService(UrunlerRepository repository) {
        this.repository = repository;
    }

    public List<Urunler> UrunFullGetir() {
        return repository.findAll();
    }

    public Urunler urunGetir(Integer urunId) {
        return repository.findById(urunId)
                .orElseThrow(() -> new RuntimeException("Sipariş bulunamadı: " + urunId));
    }

    public Urunler UrunEkle(Urunler yeniUrun) {

        return repository.save(yeniUrun);
    }

    public Urunler urunGuncelle(Integer urunId, Urunler guncelUrun) {
        Urunler mevcut = repository.findById(urunId)
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı: " + urunId));
        mevcut.setUrun(guncelUrun.getUrun());
        return repository.save(mevcut);
    }

    public void urunSil(Integer urunId) {
        if (!repository.existsById(urunId)) {
            throw new RuntimeException("Ürün bulunamadı: " + urunId);
        }
        repository.deleteById(urunId);
    }
}
