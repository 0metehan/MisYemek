package com.example.misyemek.repository;

import com.example.misyemek.entity.Bildirim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BildirimRepository extends JpaRepository<Bildirim,Long> {


    @Query("SELECT b " +
            "FROM Bildirim b " +
            "WHERE b.kullaniciId = :kullaniciId " +
            "ORDER BY b.bildirimTarih DESC")
    List<Bildirim> kullaniciBildirimGetir(@Param("kullaniciId") Long kullaniciId);

}
