package com.example.misyemek.repository;

import com.example.misyemek.entity.Sipariş;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;


public interface SiparişRepository extends JpaRepository<Sipariş,Long>{

    @Query("SELECT COALESCE(SUM(s.adet * s.firmaUrun.fiyat), 0) " +
            "FROM Sipariş s " +
            "WHERE s.kullanıcıId = :kullaniciId " +
            "AND s.firmaUrun.firmaId = :firmaId " +
            "AND s.siparisDurumu = com.example.misyemek.Enum.SiparisDururmu.TESLIM_EDILDI")
    BigDecimal toplamHarcama(@Param("kullaniciId") Long kullaniciId,
                             @Param("firmaId") Long firmaId);


    @Query("SELECT COALESCE(SUM(s.adet * s.firmaUrun.fiyat), 0) " +
            "FROM Sipariş s " +
            "WHERE s.firmaUrun.firmaId = :firmaId")
    BigDecimal toplamCiro(@Param("firmaId") Long firmaId);

    @Query("SELECT COALESCE(SUM(s.adet * s.firmaUrun.fiyat), 0) " +
            "FROM Sipariş s " +
            "WHERE s.firmaUrun.firmaId = :firmaId " +
            "AND YEAR(s.tarihSaat) = :yil " +
            "AND MONTH(s.tarihSaat) = :ay " +
            "AND s.siparisDurumu = com.example.misyemek.Enum.SiparisDururmu.TESLIM_EDILDI")
    BigDecimal firmaUrunAylikKazanc(@Param("firmaId") Long firmaId,
                                @Param("yil") int yil,
                                @Param("ay") int ay);
}
