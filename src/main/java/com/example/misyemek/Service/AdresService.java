package com.example.misyemek.Service;

import com.example.misyemek.entity.Adres;
import com.example.misyemek.repository.AdresRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdresService {

    private final AdresRepository repository;

    public AdresService(AdresRepository repository) {
        this.repository = repository;
    }

    public List<Adres> adresGetir(){
        return repository.findAll();
    }

    public Adres adresKaydet(Adres yeniAdres){
        return repository.save(yeniAdres);
    }

    public Adres adresGuncelle(Long adresId , Adres guncelAdres){
        Adres mevcut = repository.findById(adresId)
                .orElseThrow(()-> new RuntimeException("konum bulunamadı"));
        mevcut.setIlce(guncelAdres.getIlce());
        mevcut.setMahalle(guncelAdres.getMahalle());
        mevcut.setSehir(guncelAdres.getSehir());
        return repository.save(mevcut);
    }

    public void adresSil(Long adresId){
        if (!repository.existsById(adresId)){
            throw new RuntimeException("adres bulunamadı");
        }
        repository.deleteById(adresId);
    }

    public List<Object[]> enYakinFirma(Long kullaniciId){
       return repository.enYakinFirma(kullaniciId);
    }
    public List<Object[]> urunListele(Long kullaniciId , Long urunId){
        return repository.urunListele(kullaniciId , urunId);
    }

}
