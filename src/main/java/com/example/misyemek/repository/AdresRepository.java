package com.example.misyemek.repository;

import com.example.misyemek.entity.Adres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AdresRepository extends JpaRepository<Adres, Long> {

   @Query(value = "SELECT " +
            " k.kullanici_adi, " +
            " ka.sehir AS kullanici_sehir, " +
            " ka.ilce AS kullanici_ilce, " +
            " ka.mahalle AS kullanici_mahalle, " +
            " f.firma_adi, " +
            " fa.sehir AS firma_sehir, " +
            " fa.ilce AS firma_ilce, " +
            " fa.mahalle AS firma_mahalle, " +
            " u.urun_adi, " +
            " fu.fiyat, " +
            " CASE " +
            " WHEN fu.fiyat < 100 THEN 'kurye ücreti alınır' " +
            " ELSE 'kurye ücreti alınmaz' " +
            " END AS kurye_ucret_durumu, " +
            " CASE " +
            " WHEN ka.mahalle = fa.mahalle THEN 'mahalle' " +
            " WHEN ka.ilce = fa.ilce THEN 'ilçe' " +
            " ELSE 'şehir' " +
            " END AS yakinlik_derecesi " +
            " FROM kullanici k " +
            " INNER JOIN adres ka ON k.kullanici_adres_id = ka.adres_id " +
            " INNER JOIN adres fa ON ka.sehir = fa.sehir " +
            " INNER JOIN firma f ON f.firma_adres_id = fa.adres_id " +
            " INNER JOIN firma_urun fu ON fu.firma_id = f.firma_id " +
            " INNER JOIN urun u ON u.urun_id = fu.urun_id " +
            " WHERE k.kullanici_id = :kullaniciId " +
            " ORDER BY yakinlik_derecesi, fu.fiyat ", nativeQuery = true)
    List<Object[]> enYakinFirma(@Param("kullanici_id") Long kullaniciId);
}
