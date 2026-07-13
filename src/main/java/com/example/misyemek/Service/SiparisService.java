package com.example.misyemek.Service;

import com.example.misyemek.entity.Siparis;
import com.example.misyemek.repository.SiparisRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SiparisService {
    private final SiparisRepository repository;

    public SiparisService(SiparisRepository repository) {
        this.repository = repository;
    }

    public Siparis siparisEkle(Siparis yeniSiparis) {
        return repository.save(yeniSiparis);
    }

    public List<Siparis> siparisFullGetir() {
        return repository.findAll();
    }

    public Siparis siparisGetir(Long siparisId) {
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


    public BigDecimal toplamCiro(Long firmaId) {
        return repository.toplamCiro(firmaId);
    }


}
