package com.example.misyemek.repository;

import com.example.misyemek.entity.Firma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static javax.swing.text.html.HTML.Tag.SELECT;

public interface FirmaRepository extends JpaRepository<Firma, Long> {
    @Query(value="SELECT * FROM Firma WHERE LOWER(firma_adi) LIKE LOWER(CONCAT('%', :kullaniciAdi, '%'))" ,nativeQuery = true)
    List<Firma> firmaAdiGetir(@Param("kullaniciAdi") String kullaniciAdi);
    long countByFirmaAdresId(Long adresId);

    @Query(value = "SELECT " +
            "f.firma_adi, fa.sehir, fa.ilce, fa.mahalle, " +
            "CASE " +
            "WHEN ka.mahalle = fa.mahalle THEN 'mahalle' " +
            "WHEN ka.ilce = fa.ilce THEN 'ilçe' " +
            "ELSE 'şehir' END AS yakinlik_derecesi, " +
            "f.firma_id, f.puan_ortalama " +
            "FROM kullanici k " +
            "INNER JOIN adres ka ON k.kullanici_adres_id = ka.adres_id " +
            "INNER JOIN adres fa ON ka.sehir = fa.sehir " +
            "INNER JOIN firma f ON f.firma_adres_id = fa.adres_id " +
            "WHERE k.kullanici_id = :kullaniciId " +
            "ORDER BY f.puan_ortalama DESC", nativeQuery = true)
    List<Object[]> yildizPuan(@Param("kullaniciId") Long kullaniciId);
}

//lower --> büyük küçük harf uyarsızlığı
//concat --> birleştirme işlevi
