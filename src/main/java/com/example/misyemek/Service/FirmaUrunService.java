package com.example.misyemek.Service;
import com.example.misyemek.entity.FirmaUrun;
import com.example.misyemek.entity.Urunler;
import com.example.misyemek.repository.FirmaUrunRepository;
import com.example.misyemek.repository.SiparisRepository;
import org.springframework.stereotype.Service;
import com.example.misyemek.repository.UrunlerRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class FirmaUrunService {
    private final FirmaUrunRepository repository;
    private final SiparisRepository siparisRepository;
    private final UrunlerRepository urunlerRepository;

    public FirmaUrunService(FirmaUrunRepository repository, SiparisRepository siparisRepository, UrunlerRepository urunlerRepository) {
        this.repository = repository;
        this.siparisRepository = siparisRepository;
        this.urunlerRepository = urunlerRepository;
    }

    public List<FirmaUrun> urunFiyatFullGetir() {
        return repository.findAll();
    }

    public List<FirmaUrun> firmaUrunGetir(Long firmaId){
        return repository.firmaUrunGetir(firmaId);
    }

    public FirmaUrun urunEkle(FirmaUrun yeniUrunFirma) {
        return repository.save(yeniUrunFirma);
    }

    public FirmaUrun gunceleFirmaUrun (Long id , FirmaUrun guncelFirma){
        FirmaUrun mevcut = repository.findById(id)
                .orElseThrow(() ->new RuntimeException("firmanın ürünü bulunamdı: "+id));
        mevcut.setFiyat(guncelFirma.getFiyat());
        return repository.save(mevcut);
    }

    public void firmaUrunSil(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("firma ürün bulunamadı: " + id);
        }
        if (siparisRepository.existsByFirmaUrunId(id)) {
            throw new RuntimeException("Bu ürüne ait siparişler var, silinemez");
        }
        repository.deleteById(id);
    }

    public BigDecimal firmaUrunAylikKazanc(Long firmaId, int yil, int ay) {
        return siparisRepository.firmaUrunAylikKazanc(firmaId, yil, ay);
    }

    public List<Object[]> yemekListele(){
        return repository.yemekListele();
    }

    @Transactional
    public FirmaUrun firmaUrunEkle(Long firmaId , String urunAdi , BigDecimal fiyat) {
        Optional<Urunler> bulunan = urunlerRepository.findByUrunIgnoreCase(urunAdi);
        long id;
        if (bulunan.isPresent()) {   //isPersent() içi dolu mu boşmu döner
           id = bulunan.get().getUrunId();
        } else {
        Urunler yeniUrun = new Urunler();
        yeniUrun.setUrun(urunAdi);
        Urunler kaydedilen = urunlerRepository.save(yeniUrun);
        id = kaydedilen.getUrunId();
        }

        FirmaUrun yeniKayit = new FirmaUrun();
        yeniKayit.setFirmaId(firmaId);
        yeniKayit.setUrunId(id);
        yeniKayit.setFiyat(fiyat);

        return repository.save(yeniKayit);
    }
}
