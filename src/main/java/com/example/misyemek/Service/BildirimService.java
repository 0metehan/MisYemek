package com.example.misyemek.Service;

import com.example.misyemek.entity.Bildirim;
import com.example.misyemek.repository.BildirimRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BildirimService {
    private final BildirimRepository repository;

    public BildirimService(BildirimRepository repository) {
        this.repository = repository;
    }

    public List<Bildirim> kullaniciBildirimGetir(Long kullaniciId){
        return repository.kullaniciBildirimGetir(kullaniciId);
    }
    public Bildirim bildirimEkle(Long kullaniciId, String metin){
        Bildirim bildirim = new Bildirim();
        bildirim.setKullaniciId(kullaniciId);
        bildirim.setBildirimMetni(metin);
        bildirim.setBildirimTarih(new Date());
        return repository.save(bildirim);
    }

    public void bildirimSil(Long bildirimId){
        repository.deleteById(bildirimId);
    }
}
