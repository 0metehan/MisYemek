package com.example.misyemek.Service;

import com.example.misyemek.entity.Adres;
import com.example.misyemek.entity.Kullanici;
import com.example.misyemek.repository.FirmaRepository;

import com.example.misyemek.repository.AdresRepository;
import com.example.misyemek.repository.KullaniciRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KullaniciService {

    private final KullaniciRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final FirmaRepository firmaRepository;
    private final AdresRepository adresRepository;

    public KullaniciService(KullaniciRepository repository, PasswordEncoder passwordEncoder, FirmaRepository firmaRepository, AdresRepository adresRepository) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.firmaRepository = firmaRepository;
        this.adresRepository = adresRepository;
    }

    public Kullanici kullaniciGetir(Long KullaniciId){
        return repository.findById(KullaniciId)
                .orElseThrow(() -> new RuntimeException("kukkalnıcı bulunamadı: " + KullaniciId));
    }

    public List<Kullanici> kullaniciFullGetir(){
        return repository.findAll();
    }

@Transactional
    public Kullanici kullaniciGuncelle(Long KullaniciId, Kullanici guncelKullanici){
        Kullanici mevcut = repository.findById(KullaniciId)
                .orElseThrow(() -> new RuntimeException("kullanıcı bulunamadı"+ KullaniciId));
        if(guncelKullanici.getKullaniciAdi()!=null) {
            mevcut.setKullaniciAdi(guncelKullanici.getKullaniciAdi());
        }
        if (guncelKullanici.getKullaniciTelNo()!=null) {
            mevcut.setKullaniciTelNo(guncelKullanici.getKullaniciTelNo());
        }
        if (guncelKullanici.getKullaniciSifresi() != null){
            mevcut.setKullaniciSifresi(passwordEncoder.encode(guncelKullanici.getKullaniciSifresi()));
        }

        if (guncelKullanici.getAdres() != null) {
            Long eskiAdresId = mevcut.getKullaniciAdresId();
            Adres gelen = guncelKullanici.getAdres();

            if (eskiAdresId == null) {
                Adres yeniAdres = new Adres();
                yeniAdres.setSehir(gelen.getSehir());
                yeniAdres.setIlce(gelen.getIlce());          //yeni kullanıcıların adresi olmadığı için yazıldı.
                yeniAdres.setMahalle(gelen.getMahalle());
                adresRepository.save(yeniAdres);
                mevcut.setKullaniciAdresId(yeniAdres.getAdresId());
            } else {
                Adres eskiAdres = adresRepository.findById(eskiAdresId)
                        .orElseThrow(() -> new RuntimeException("adres yok"));

                long kullaniciSayisi = repository.countByKullaniciAdresId(eskiAdresId);

                long firmaSayisi = firmaRepository.countByFirmaAdresId(eskiAdresId);

                if (kullaniciSayisi > 1 || firmaSayisi > 0) {
                    Adres yeniAdres = new Adres();
                    yeniAdres.setSehir(eskiAdres.getSehir());
                    yeniAdres.setIlce(eskiAdres.getIlce());
                    yeniAdres.setMahalle(eskiAdres.getMahalle());

                    if (gelen.getSehir() != null) {
                        yeniAdres.setSehir(gelen.getSehir());
                    }
                    if (gelen.getIlce() != null) {
                        yeniAdres.setIlce(gelen.getIlce());
                    }
                    if (gelen.getMahalle() != null) {
                        yeniAdres.setMahalle(gelen.getMahalle());
                    }

                    adresRepository.save(yeniAdres);
                    mevcut.setKullaniciAdresId(yeniAdres.getAdresId());
                } else {

                    if (gelen.getSehir() != null) {
                        eskiAdres.setSehir(gelen.getSehir());
                    }
                    if (gelen.getIlce() != null) {
                        eskiAdres.setIlce(gelen.getIlce());
                    }
                    if (gelen.getMahalle() != null) {
                        eskiAdres.setMahalle(gelen.getMahalle());
                    }

                    adresRepository.save(eskiAdres);
                }
            }
        }
        return repository.save(mevcut);
    }

public void kullaniciSil(Long id){
        if (!repository.existsById(id)){
            throw new RuntimeException("id yok"+ id);
        }
        repository.deleteById(id);
}


    public Kullanici kullaniciEkle(Kullanici yeniKullanici){
        yeniKullanici.setKullaniciSifresi(passwordEncoder.encode(yeniKullanici.getKullaniciSifresi()));
        return repository.save(yeniKullanici);
    }
}
