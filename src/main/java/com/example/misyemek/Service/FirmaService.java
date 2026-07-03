package com.example.misyemek.Service;

import com.example.misyemek.entity.Firma;
import com.example.misyemek.repository.FirmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirmaService {

    private final FirmaRepository repository;

    public FirmaService(FirmaRepository repository) {
        this.repository = repository;
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

    public Firma firmaGuncelle(Long firmaId, Firma guncelFirma){
        Firma mevcut = repository.findById(firmaId)
                .orElseThrow(() -> new RuntimeException("firma bulunamadı: "+ firmaId));
        mevcut.setFirmaAd(guncelFirma.getFirmaAd());
        mevcut.setFirmaTelNo(guncelFirma.getFirmaTelNo());
        return repository.save(mevcut);
    }

    public void firmaSil(Long firmaId){
        if (!repository.existsById(firmaId)) {
            throw new RuntimeException("firma bulunamadı: " + firmaId);
        }
        repository.deleteById(firmaId);

    }
}