package com.example.misyemek.Service;
import com.example.misyemek.entity.FirmaUrun;
import com.example.misyemek.repository.FirmaUrunRepository;
import com.example.misyemek.repository.SiparisRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class FirmaUrunService {
    private final FirmaUrunRepository repository;
    private final SiparisRepository siparisRepository;

    public FirmaUrunService(FirmaUrunRepository repository, SiparisRepository siparisRepository) {
        this.repository = repository;
        this.siparisRepository = siparisRepository;
    }

    public List<FirmaUrun> urunFiyatFullGetir() {
        return repository.findAll();
    }

    public FirmaUrun firmaUrunGetir(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sipariş bulunamadı: " + id));
    }

    public FirmaUrun urunFiyatEkle(FirmaUrun yeniUrunFirma) {
//        if (yeniUrunFirma.getFiyat() == null || yeniUrunFirma.getFiyat() < 0) {
//            throw new IllegalArgumentException("Fiyat negatif veya boş olamaz");
//        }
        return repository.save(yeniUrunFirma);
    }

    public FirmaUrun gunceleFirmaUrun (Long id , FirmaUrun guncelFirma){
        FirmaUrun mevcut = repository.findById(id)
                .orElseThrow(() ->new RuntimeException("firmanın ürünü bulunamdı: "+id));
        mevcut.setFiyat(guncelFirma.getFiyat());
        return repository.save(mevcut);
    }

    public void firmaUrunSil(Long id){
        if (!repository.existsById(id)) {
            throw new RuntimeException("id bulunamadı: " + id);
        }
        repository.deleteById(id);
    }

    public BigDecimal firmaUrunAylikKazanc(Long firmaId, int yil, int ay) {
        return siparisRepository.firmaUrunAylikKazanc(firmaId, yil, ay);
    }

}
