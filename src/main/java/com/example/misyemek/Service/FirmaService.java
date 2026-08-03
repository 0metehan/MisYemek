package com.example.misyemek.Service;

import com.example.misyemek.entity.Firma;
import com.example.misyemek.repository.FirmaRepository;
import com.example.misyemek.repository.KullaniciRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.misyemek.entity.Adres;
import com.example.misyemek.repository.AdresRepository;

import java.util.List;

@Service
public class FirmaService {

    private final AdresRepository adresRepository;
    private final FirmaRepository repository;
    private final KullaniciRepository kullaniciRepository;


    public FirmaService(FirmaRepository repository, AdresRepository adresRepository, KullaniciRepository kullaniciRepository) {
        this.repository = repository;
        this.adresRepository = adresRepository;
        this.kullaniciRepository = kullaniciRepository;
    }

    public List<Firma> firmaAdiGetir(String firmaAdi){
        return repository.firmaAdiGetir(firmaAdi);
    }

    public List<Firma> firmaFullGetir() {
        return repository.findAll();
    }

    public Firma firmaGetir(Long firmaId){
        return repository.findById(firmaId)
                .orElseThrow(() -> new RuntimeException("Sipariş bulunamadı: " + firmaId));
    }

    public Firma firmaEkle(Firma yeniFirma) {
        return repository.save(yeniFirma);
    }

    @Transactional
    public Firma firmaGuncelle(Long firmaId, Firma guncelFirma){
        Firma mevcut = repository.findById(firmaId)
                .orElseThrow(() -> new RuntimeException("firma bulunamadı: "+ firmaId));

        if (guncelFirma.getFirmaAd() != null){
            mevcut.setFirmaAd(guncelFirma.getFirmaAd());
        }
        if (guncelFirma.getFirmaTelNo() != null){
            mevcut.setFirmaTelNo(guncelFirma.getFirmaTelNo());
        }

        // Firmanın adresini güncelleme güncelleme işlemi yapar
        if (guncelFirma.getAdres() != null) {
            Long eskiAdresId = mevcut.getFirmaAdresId();
            Adres gelen = guncelFirma.getAdres();
            Adres eskiAdres = adresRepository.findById(eskiAdresId)
                    .orElseThrow(() -> new RuntimeException("adres yok"));

            long kullaniciSayisi = kullaniciRepository.countByKullaniciAdresId(eskiAdresId);

            long firmaSayisi = repository.countByFirmaAdresId(eskiAdresId);

            if (kullaniciSayisi > 0 || firmaSayisi > 1){
                Adres yeniAdres = new Adres();
                yeniAdres.setSehir(eskiAdres.getSehir());
                yeniAdres.setIlce(eskiAdres.getIlce());
                yeniAdres.setMahalle(eskiAdres.getMahalle());

                if (gelen.getSehir() != null){
                    yeniAdres.setSehir(gelen.getSehir());
                }
                if (gelen.getIlce() != null) {
                    yeniAdres.setIlce(gelen.getIlce());
                }
                if (gelen.getMahalle() != null){
                    yeniAdres.setMahalle(gelen.getMahalle());
                }

                adresRepository.save(yeniAdres);
                mevcut.setFirmaAdresId(yeniAdres.getAdresId());
            } else {
                if (gelen.getSehir() != null) {
                    eskiAdres.setSehir(gelen.getSehir());
                }
                if (gelen.getIlce() != null) {
                    eskiAdres.setIlce(gelen.getIlce());
                }
                if (gelen.getMahalle() != null){
                    eskiAdres.setMahalle(gelen.getMahalle());
                }
                adresRepository.save(eskiAdres);
            }
        }
        return repository.save(mevcut);
    }

    public void firmaSil(Long firmaId){
        if (!repository.existsById(firmaId)) {
            throw new RuntimeException("firma bulunamadı: " + firmaId);
        }
        repository.deleteById(firmaId);
    }
    public List<Object[]> yildizaGoreSirala(Long kullaniciId){
        return repository.yildizPuan(kullaniciId);
    }
}