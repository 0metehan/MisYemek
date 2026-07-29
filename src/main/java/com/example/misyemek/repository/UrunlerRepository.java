package com.example.misyemek.repository;

import com.example.misyemek.entity.Urunler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import static javax.swing.text.html.HTML.Tag.SELECT;

public interface UrunlerRepository extends JpaRepository<Urunler, Integer> {
    Optional<Urunler> findByUrunIgnoreCase(String urun);

    List<Urunler> findByUrunTuru(String urunTuru);
}
