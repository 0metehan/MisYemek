package com.example.misyemek.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "urun")
public class Urunler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Positive
    @Column(name="urun_id")
    private Integer urunId;

    @NotBlank(message = "Ürün ismi boş olamaz")
    @Column(name="urun_adi")
    private String urun;

    @Column(name = "urun_turu")
    private String urunTuru;

    public String getUrun() {
        return urun;
    }

    public void setUrun(String urun) {
        this.urun = urun;
    }

    public Integer getUrunId() {
        return urunId;
    }

    public void setUrunId(Integer urunId) {
        this.urunId = urunId;
    }

    public String getUrunTuru() {
        return urunTuru;
    }

    public void setUrunTuru(String urunTuru) {
        this.urunTuru = urunTuru;
    }
}
