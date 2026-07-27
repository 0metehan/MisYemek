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
}
