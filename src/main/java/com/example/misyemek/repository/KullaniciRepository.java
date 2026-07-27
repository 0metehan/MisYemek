package com.example.misyemek.repository;

import com.example.misyemek.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KullaniciRepository extends JpaRepository<Kullanici,Long> {
    Optional<Kullanici> findByKullaniciAdi(String kullaniciAdi);
    long countByKullaniciAdresId(Long adresId);

}
