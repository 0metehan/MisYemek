package com.example.misyemek.repository;

import com.example.misyemek.entity.Adres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AdresRepository extends JpaRepository<Adres, Long> {

    @Query(value = "SELECT " +
            "f.firma_adi, " +
            "fa.sehir AS firma_sehir, " +
            "fa.ilce AS firma_ilce, " +
            "fa.mahalle AS firma_mahalle, " +
            "CASE " +
            "WHEN ka.mahalle = fa.mahalle THEN 'mahalle' " +
            "WHEN ka.ilce = fa.ilce THEN 'ilçe' " +
            "ELSE 'şehir' " +
            "END AS yakinlik_derecesi, " +
            "f.firma_id, " +
            "f.puan_ortalama " +
            "FROM kullanici k " +
            "INNER JOIN adres ka ON k.kullanici_adres_id = ka.adres_id " +
            "INNER JOIN adres fa ON ka.sehir = fa.sehir " +
            "INNER JOIN firma f ON f.firma_adres_id = fa.adres_id " +
            "WHERE k.kullanici_id = :kullaniciId " +
            "ORDER BY CASE " +
            "WHEN ka.mahalle = fa.mahalle THEN 1 " +
            "WHEN ka.ilce = fa.ilce THEN 2 " +
            "ELSE 3 END, f.firma_adi ", nativeQuery = true)
    List<Object[]> enYakinFirma(@Param("kullaniciId") Long kullaniciId);

    @Query(value = "SELECT " +
            "f.firma_adi, " +
            "fa.sehir AS firma_sehir, " +
            "fa.ilce AS firma_ilce, " +
            "fa.mahalle AS firma_mahalle, " +
            "CASE " +
            "WHEN ka.mahalle = fa.mahalle THEN 'mahalle' " +
            "WHEN ka.ilce = fa.ilce THEN 'ilçe' " +
            "ELSE 'şehir' " +
            "END AS yakinlik_derecesi, " +
            "f.firma_id, " +
            "f.puan_ortalama " +
            "FROM kullanici k " +
            "INNER JOIN adres ka ON k.kullanici_adres_id = ka.adres_id " +
            "INNER JOIN adres fa ON ka.sehir = fa.sehir " +
            "INNER JOIN firma f ON f.firma_adres_id = fa.adres_id " +
            "WHERE k.kullanici_id = :kullaniciId " +
            "AND f.firma_id IN (SELECT fu.firma_id FROM firma_urun fu WHERE fu.urun_id = :urunId) " +
            "ORDER BY CASE " +
            "WHEN ka.mahalle = fa.mahalle THEN 1 " +
            "WHEN ka.ilce = fa.ilce THEN 2 " +
            "ELSE 3 END, f.firma_adi ", nativeQuery = true)
    List<Object[]> urunListele(@Param("kullaniciId") Long kullaniciId , @Param("urunId") Long urunId);
}
