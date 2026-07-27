package com.example.misyemek.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "firma_sahibi")
public class FirmaSahibi {

    @Id
    @Column(name = "firma_sahibi_id")
    private Long firmaSahibiId;

    @ManyToOne
    @JoinColumn(name = "firma_id")
    private Firma firmaId;

    @ManyToOne
    @JoinColumn(name = "kullanici_id")
    private Kullanici kullaniciId;

    public Long getFirmaSahibiId() {
        return firmaSahibiId;
    }

    public void setFirmaSahibiId(Long firmaSahibiId) {
        this.firmaSahibiId = firmaSahibiId;
    }

    public Firma getFirmaId() {
        return firmaId;
    }

    public void setFirmaId(Firma firmaId) {
        this.firmaId = firmaId;
    }

    public Kullanici getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(Kullanici kullaniciId) {
        this.kullaniciId = kullaniciId;
    }
}
