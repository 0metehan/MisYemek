package com.example.misyemek.Service;

import com.example.misyemek.entity.Kullanici;

import com.example.misyemek.repository.KullaniciRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KullaniciService {

    private final KullaniciRepository repository;

    private final PasswordEncoder passwordEncoder;

    public KullaniciService(KullaniciRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public Kullanici kullaniciGetir(Long KullaniciId){
        return repository.findById(KullaniciId)
                .orElseThrow(() -> new RuntimeException("Sipariş bulunamadı: " + KullaniciId));
    }

    public List<Kullanici> kullaniciFullGetir(){
        return repository.findAll();
    }


    public Kullanici kullaniciGuncelle(Long KullaniciId, Kullanici guncelKullanici){
        Kullanici mevcut = repository.findById(KullaniciId)
                .orElseThrow(() -> new RuntimeException("kullanıcı bulunamadı"+ KullaniciId));
        mevcut.setKullaniciAdi(guncelKullanici.getKullaniciAdi());
        mevcut.setKullaniciRol(guncelKullanici.getKullaniciRol());
        mevcut.setKullaniciSifresi(guncelKullanici.getKullaniciSifresi());
        mevcut.setKullaniciTelNo(guncelKullanici.getKullaniciTelNo());
        return repository.save(mevcut);
    }

public void kullaniciSil(Long id){
        if (!repository.existsById(id)){
            throw new RuntimeException("id yok"+ id);
        }
        repository.deleteById(id);
}


    public Kullanici kullaniciEkle(Kullanici yeniKullanici){
        yeniKullanici.setKullaniciSifresi(
                passwordEncoder.encode(yeniKullanici.getKullaniciSifresi())
        );
        return repository.save(yeniKullanici);
    }
}
