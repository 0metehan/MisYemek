package com.example.misyemek.Service;

import com.example.misyemek.entity.Kullanıcı;
import com.example.misyemek.repository.KullanıcıRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KullanıcıService {

    private final KullanıcıRepository repository;

    public KullanıcıService(KullanıcıRepository repository) {
        this.repository = repository;
    }

    public Kullanıcı kullanıcıGetir(Long KullanıcıId){
        return repository.findById(KullanıcıId)
                .orElseThrow(() -> new RuntimeException("Sipariş bulunamadı: " + KullanıcıId));
    }

    public List<Kullanıcı> kullanıcıFullGetir(){
        return repository.findAll();
    }

    public Kullanıcı kullanıcıEkle(Kullanıcı yeniKullanıcı){
        return repository.save(yeniKullanıcı);
    }

    public Kullanıcı kullaniciGuncelle(Long KullanıcıId, Kullanıcı guncelKullanıcı){
        Kullanıcı mevcut = repository.findById(KullanıcıId)
                .orElseThrow(() -> new RuntimeException("kullanıcı bulunamadı"+ KullanıcıId));
        mevcut.setKullanıcıAdı(guncelKullanıcı.getKullanıcıAdı());
        mevcut.setKullanıcıRol(guncelKullanıcı.getKullanıcıRol());
        mevcut.setKullanıcıSifresi(guncelKullanıcı.getKullanıcıSifresi());
        mevcut.setKullanıcıTelNo(guncelKullanıcı.getKullanıcıTelNo());
        return repository.save(mevcut);
    }

public void kullaniciSil(Long id){
        if (!repository.existsById(id)){
            throw new RuntimeException("id yok"+ id);
        }
        repository.deleteById(id);
}
}
