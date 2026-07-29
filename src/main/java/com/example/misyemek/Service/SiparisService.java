package com.example.misyemek.Service;

import com.example.misyemek.entity.Siparis;
import com.example.misyemek.repository.SiparisRepository;
import org.springframework.stereotype.Service;
import com.example.misyemek.Enum.SiparisDurumu;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static com.example.misyemek.Enum.SiparisDurumu.*;

@Service
public class SiparisService {
    private final SiparisRepository repository;

    public SiparisService(SiparisRepository repository) {
        this.repository = repository;
    }

    public Siparis siparisEkle(Siparis yeniSiparis) {
        return repository.save(yeniSiparis);
    }

    public List<Object[]> kullaniciIdSiparisGetir(Long kullaniciId) {
        return repository.kullaniciIdSiparisGetir(kullaniciId);

    }
    public List<Object[]> firmaIdSiparisGetir(Long firmaId){
        return  repository.firmaIdSiparisGetir(firmaId);
    }

    public List<Siparis> siparisGetir(Long kullaniciId) {
        return repository.findByKullaniciId(kullaniciId);

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

    public List<Siparis> sepetGetir(Long kullaniciId){
        return repository.findByKullaniciIdAndSiparisDurumu(kullaniciId, SEPETTE);}

    @Transactional
    public List<Siparis> sepetGuncelle(Long kullaniciId){
        List<Siparis> sepet = repository.findByKullaniciIdAndSiparisDurumu(kullaniciId, SEPETTE);
        for (Siparis s : sepet) {
            s.setSiparisDurumu(SiparisDurumu.HAZIRLANIYOR);
        }
        return repository.saveAll(sepet);
    }

    public Siparis sepetOnayla(Long siparisId){
        Siparis siparis = repository.findById(siparisId)
                .orElseThrow(() -> new RuntimeException("sipariş bulunamadı"));

        siparis.setSiparisDurumu(SiparisDurumu.YOLDA);
        return repository.save(siparis);
    }

    public Siparis sepetReddet(Long siparisId){
        Siparis siparis = repository.findById(siparisId)
                .orElseThrow(() -> new RuntimeException("sipariş bulunamadı"));

        siparis.setSiparisDurumu(SiparisDurumu.IPTAL);
        return repository.save(siparis);
    }

    public List<Object[]> kuryeSiparis(){
        return repository.kuryeSiparis();
    }

    public Siparis kuryeSiparisTeslimEdildi(Long siparisId){
        Siparis siparis = repository.findById(siparisId)
                .orElseThrow(() -> new RuntimeException("siparis bulunamadı"));

        siparis.setSiparisDurumu(SiparisDurumu.TESLIM_EDILDI);
        return repository.save(siparis);
    }

    public Siparis kuryeSiparisReddet(Long siparisId){
        Siparis siparis = repository.findById(siparisId)
                .orElseThrow(() -> new RuntimeException("siparis bulunamadı"));

        siparis.setSiparisDurumu(SiparisDurumu.IPTAL);
        return repository.save(siparis);
    }

    public List<Object[]> firmaSiparisTakip (Long firmaId){
        return repository.firmaSiparisTakip(firmaId);
    }
    public Long firmaTeslimSayac(Long firmaId , int yil , int ay ){
        return repository.firmaTeslimSayac(firmaId,yil,ay);
    }

    public Long firmaIptalSayac(Long firmaId , int yil , int ay ){
        return repository.firmaIptalSayac(firmaId,yil,ay);
    }
}
