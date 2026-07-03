package com.example.misyemek.Service;

import com.example.misyemek.entity.Sipariş;
import com.example.misyemek.repository.SiparişRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SiparişService {
    private final SiparişRepository repository;

    public SiparişService(SiparişRepository repository) {
        this.repository = repository;
    }

    public Sipariş siparişEkle(Sipariş yeniSipariş) {
        return repository.save(yeniSipariş);
    }

    public List<Sipariş> siparişFullGetir() {
        return repository.findAll();
    }

    public Sipariş siparişGetir(Long siparisId) {
        return repository.findById(siparisId)
                .orElseThrow(() -> new RuntimeException("Sipariş bulunamadı: " + siparisId));
    }

    public void siparisSil(Long siparisId) {
        if (!repository.existsById(siparisId)) {
            throw new RuntimeException("sipariş bulunamadı" + siparisId);
        }
        repository.deleteById(siparisId);
    }

    public BigDecimal toplamHarcama(Long kullaniciId, Long firmaId){
        return repository.toplamHarcama(kullaniciId, firmaId);
    }

    // SiparişService.java
    public BigDecimal toplamCiro(Long firmaId) {
        return repository.toplamCiro(firmaId);
    }
}
