package com.example.misyemek.repository;

import com.example.misyemek.entity.FirmaSahibi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FirmaSahibiRepository extends JpaRepository<FirmaSahibi, Long> {
    @Query("SELECT fs FROM FirmaSahibi fs WHERE fs.kullaniciId.id = :kullaniciId")
    FirmaSahibi firmaSahibiGetir(@Param("kullaniciId") Long kullaniciId);
}
