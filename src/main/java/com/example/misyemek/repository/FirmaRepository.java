package com.example.misyemek.repository;

import com.example.misyemek.entity.Firma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FirmaRepository extends JpaRepository<Firma, Long> {
    @Query(value="SELECT * FROM Firma WHERE LOWER(firma_adi) LIKE LOWER(CONCAT('%', :kullaniciAdi, '%'))" ,nativeQuery = true)
    List<Firma> firmaAdiGetir(@Param("kullaniciAdi") String kullaniciAdi);
    long countByFirmaAdresId(Long adresId);
}

//lower --> büyük küçük harf uyarsızlığı
//concat --> birleştirme işlevi
