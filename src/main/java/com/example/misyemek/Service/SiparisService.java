package com.example.misyemek.Service;

import com.example.misyemek.entity.Firma;
import com.example.misyemek.entity.Siparis;
import com.example.misyemek.repository.FirmaRepository;
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
    private final FirmaRepository firmaRepository;

    public SiparisService(SiparisRepository repository, FirmaRepository firmaRepository) {
        this.repository = repository;
        this.firmaRepository = firmaRepository;
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
        int grupNo = repository.maxGrupNo() + 1;
        for (Siparis s : sepet) {
            s.setSiparisDurumu(SiparisDurumu.HAZIRLANIYOR);
            s.setGrupNo(grupNo);
        }

        return repository.saveAll(sepet);
    }

    public Siparis sepetOnayla(Long siparisId){
        Siparis siparisler = repository.findById(siparisId)
                .orElseThrow(() -> new RuntimeException("kullanıcı ıd bulunamadı") );
            siparisler.setSiparisDurumu(SiparisDurumu.YOLDA);
        return repository.save(siparisler);
    }

    public Siparis sepetReddet(Long kullaniciId){
    Siparis siparisler =repository.findById(kullaniciId)
                    .orElseThrow(()-> new RuntimeException("kullanici bulunamadı"));
    siparisler.setSiparisDurumu(SiparisDurumu.IPTAL);
    return repository.save(siparisler);
    }

    public List<Object[]> kuryeSiparis(){
        return repository.kuryeSiparis();
    }

    @Transactional
    public List<Siparis> kuryeSiparisTeslimEdildi(int grupNo , Long firmaId){
        List<Siparis> siparisler = repository.findByGrupNoAndFirmaUrun_FirmaId(grupNo ,firmaId);
    for (Siparis s : siparisler) {
        s.setSiparisDurumu(SiparisDurumu.TESLIM_EDILDI);
    }
        return repository.saveAll(siparisler);
    }

    public List<Siparis> kuryeSiparisReddet(int grupNo , Long firmaId){
        List<Siparis> siparis = repository.findByGrupNoAndFirmaUrun_FirmaId(grupNo ,firmaId);
        for (Siparis s : siparis) {
            s.setSiparisDurumu(SiparisDurumu.IPTAL);
        }
        return repository.saveAll(siparis);
    }

    public List<Object[]> firmaSiparisTakip (Long firmaId){
        return repository.firmaSiparisTakip(firmaId);
    }

    public Long firmaTeslimSayac(Long firmaId ,int yil , int ay ){
        return repository.firmaTeslimSayac(firmaId,yil,ay);
    }

    public Long firmaIptalSayac(Long firmaId  ,int yil , int ay ){
        return repository.firmaIptalSayac(firmaId, yil , ay);
    }

    public Double yildizSay(Long firmaId){
        return repository.yildizSay(firmaId);
    }

    @Transactional
    public Siparis yildizEkle(Long firmaId, int grupNo, int yildizSayisi){
        List<Siparis> siparisler = repository.findByGrupNoAndFirmaUrun_FirmaId(grupNo, firmaId);

        if (siparisler.isEmpty()) {
            throw new RuntimeException("sipariş bulunamadı");
        }
        Siparis ilk = siparisler.get(0);
        ilk.setYildizSayisi(yildizSayisi);
        repository.save(ilk);
        Double ortalama =repository.yildizSay(firmaId);
        Firma firma = firmaRepository.findById(firmaId)
                .orElseThrow(()-> new RuntimeException("firma bulunamadı"));
        firma.setPuanOrtalama(ortalama);
        return ilk;
    }
    }

