package com.example.misyemek.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "firma_urun")
public class FirmaUrun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Positive
    @Column(name = "Urun_Firma_Id")
    private Long id;

    @NotNull(message = "Fiyat boş olamaz")
    @Positive(message = "Fiyat pozitif olmalı")
    @Column(name= "fiyat")
    private BigDecimal fiyat;

    @NotNull(message = "Firma ID boş olamaz")
    @Column(name="firma_Id")
    private Long firmaId;

    @NotNull(message = "Ürün ID boş olamaz")
    @Column(name="urun_Id")
    private Long urunId;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "firma_Id", insertable = false, updatable = false)
    private Firma firma;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "urun_Id", insertable = false, updatable = false)
    private Urunler urunler;

    public BigDecimal getFiyat() {
        return fiyat;
    }

    public void setFiyat(BigDecimal fiyat) {
        this.fiyat = fiyat;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public Urunler getUrunler() {
        return urunler;
    }

    public void setUrunler(Urunler urunler) {
        this.urunler = urunler;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFirmaId() {
        return firmaId;
    }

    public void setFirmaId(Long firmaId) {
        this.firmaId = firmaId;
    }

    public Long getUrunId() {
        return urunId;
    }

    public void setUrunId(Long urunId) {
        this.urunId = urunId;
    }
}