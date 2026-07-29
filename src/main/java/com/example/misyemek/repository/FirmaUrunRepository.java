package com.example.misyemek.repository;

import com.example.misyemek.entity.FirmaUrun;
import com.example.misyemek.entity.Urunler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FirmaUrunRepository extends JpaRepository<FirmaUrun,Long > {
@Query("SELECT f FROM FirmaUrun f JOIN FETCH f.urunler where f.firmaId = :firmaId")
    List<FirmaUrun> firmaUrunGetir(@Param("firmaId") Long firmaId);


    @Query(value = "SELECT DISTINCT " +
            "u.urun_id, " +
            "u.urun_adi " +
            "FROM firma_urun f " +
            "INNER JOIN urun u ON f.urun_id = u.urun_id " +
            "ORDER BY u.urun_adi ", nativeQuery = true)
    List<Object[]> yemekListele();

    @Query(value = "SELECT DISTINCT " +
            "f.firma_adi, " +
            "fa.sehir, " +
            "fa.ilce, " +
            "fa.mahalle, " +
            "'şehir' AS yakinlik_derecesi, " +
            "f.firma_id " +
            "FROM firma f " +
            "INNER JOIN adres fa ON f.firma_adres_id = fa.adres_id " +
            "INNER JOIN firma_urun fu ON fu.firma_id = f.firma_id " +
            "INNER JOIN urun u ON fu.urun_id = u.urun_id " +
            "WHERE u.urun_turu = :urunTuru " +
            "ORDER BY f.firma_adi ", nativeQuery = true)
    List<Object[]> turFirma(@Param("urunTuru") String urunTuru);
}
