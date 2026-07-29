package com.example.misyemek.repository;

import com.example.misyemek.Enum.SiparisDurumu;
import com.example.misyemek.entity.Siparis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;


public interface SiparisRepository extends JpaRepository<Siparis,Long>{

    @Query("SELECT COALESCE(SUM(s.adet * s.firmaUrun.fiyat), 0) " +
            "FROM Siparis s " +
            "WHERE s.kullaniciId = :kullaniciId " +
            "AND s.firmaUrun.firmaId = :firmaId " +
            "AND s.siparisDurumu = com.example.misyemek.Enum.SiparisDurumu.TESLIM_EDILDI")
    BigDecimal toplamHarcama(@Param("kullaniciId") Long kullaniciId,
                             @Param("firmaId") Long firmaId);


    @Query("SELECT COALESCE(SUM(s.adet * s.firmaUrun.fiyat), 0) " +
            "FROM Siparis s " +
            "WHERE s.firmaUrun.firmaId = :firmaId")
    BigDecimal toplamCiro(@Param("firmaId") Long firmaId);

    @Query("SELECT COALESCE(SUM(s.adet * s.firmaUrun.fiyat), 0) " +
            "FROM Siparis s " +
            "WHERE s.firmaUrun.firmaId = :firmaId " +
            "AND YEAR(s.tarihSaat) = :yil " +
            "AND MONTH(s.tarihSaat) = :ay " +
            "AND s.siparisDurumu = com.example.misyemek.Enum.SiparisDurumu.TESLIM_EDILDI")
    BigDecimal firmaUrunAylikKazanc(@Param("firmaId") Long firmaId,
                                    @Param("yil") int yil,
                                    @Param("ay") int ay);

    @Query("SELECT s.siparisId , u.urun , f.firmaAd , s.adet ,s.tarihSaat ,fu.fiyat " +
            "FROM Siparis s " +
            "JOIN s.firmaUrun fu " +
            "JOIN fu.urunler u " +
            "JOIN fu.firma f " +
            "WHERE s.kullaniciId= :kullaniciId " +
            "AND s.siparisDurumu = com.example.misyemek.Enum.SiparisDurumu.TESLIM_EDILDI")
    List<Object[]> kullaniciIdSiparisGetir (@Param("kullaniciId") Long kullaniciId);

    @Query("SELECT s.siparisId , u.urun , s.adet " +
            "FROM Siparis s " +
            "JOIN s.firmaUrun fu " +
            "JOIN fu.urunler u " +
            "WHERE fu.firmaId= :firmaId " +
            "AND s.siparisDurumu = com.example.misyemek.Enum.SiparisDurumu.HAZIRLANIYOR ")
    List<Object[]> firmaIdSiparisGetir (@Param("firmaId") Long firmaId);

    @Query("SELECT s.siparisId , u.urun , s.adet , k.kullaniciAdi , a.mahalle, a.ilce, a.sehir , k.kullaniciTelNo , f.firmaAd ,f.firmaTelNo  " +
            "FROM Siparis s " +
            "JOIN s.firmaUrun fu " +
            "JOIN fu.urunler u " +
            "JOIN Kullanici k ON k.id = s.kullaniciId " +
            "JOIN fu.firma f  " +
            "JOIN k.adres a " +
            "WHERE s.siparisDurumu = com.example.misyemek.Enum.SiparisDurumu.YOLDA")
    List<Object[]> kuryeSiparis();

    @Query("SELECT s.siparisId , s.adet, s.siparisDurumu " +
            "FROM Siparis s " +
            "JOIN s.firmaUrun fu " +
            "WHERE fu.firmaId = :firmaId " +
            "AND s.siparisDurumu IN (com.example.misyemek.Enum.SiparisDurumu.YOLDA, " +
            "com.example.misyemek.Enum.SiparisDurumu.TESLIM_EDILDI, " +
            "com.example.misyemek.Enum.SiparisDurumu.IPTAL) " +
            "ORDER BY s.siparisId DESC")
    List<Object[]> firmaSiparisTakip(@Param("firmaId") Long firmaId);

    List<Siparis> findByKullaniciIdAndSiparisDurumu(Long kullaniciId, SiparisDurumu siparisDurumu);
    boolean existsByFirmaUrunId(Long firmaUrunId);
    List<Siparis> findByKullaniciId(Long kullaniciId);

    @Query("SELECT COUNT(s) " +
            "FROM Siparis s " +
            "JOIN s.firmaUrun fu " +
            "WHERE fu.firmaId = :firmaId " +
            "AND YEAR(s.tarihSaat) = :yil " +
            "AND MONTH(s.tarihSaat) = :ay " +
            "AND s.siparisDurumu = com.example.misyemek.Enum.SiparisDurumu.TESLIM_EDILDI")
    Long firmaTeslimSayac(@Param("firmaId") Long firmaId,
                          @Param("yil") int yil,
                          @Param("ay") int ay);

    @Query("SELECT COUNT(s) " +
            "FROM Siparis s " +
            "JOIN s.firmaUrun fu " +
            "WHERE fu.firmaId = :firmaId " +
            "AND YEAR(s.tarihSaat) = :yil " +
            "AND MONTH(s.tarihSaat) = :ay " +
            "AND s.siparisDurumu = com.example.misyemek.Enum.SiparisDurumu.IPTAL")
    Long firmaIptalSayac(@Param("firmaId") Long firmaId,
                          @Param("yil") int yil,
                          @Param("ay") int ay);
}
