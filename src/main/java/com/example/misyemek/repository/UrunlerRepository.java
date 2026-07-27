package com.example.misyemek.repository;

import com.example.misyemek.entity.Urunler;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrunlerRepository extends JpaRepository<Urunler, Integer> {
    Optional<Urunler> findByUrunIgnoreCase(String urun);
}
