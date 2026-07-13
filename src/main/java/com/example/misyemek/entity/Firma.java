package com.example.misyemek.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "firma")
public class Firma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Positive
    @Column(name = "firma_id")
    private long firmaId;

    @NotBlank(message = "Firma Adı boş olamaz")
    @Column(name = "firma_adi" )
    private String firmaAd;

    @NotBlank(message = "Firma Telefon no boş olamaz")
    @Column(name = "firma_tel_no")
    private String firmaTelNo;

    @Column(name = "firma_adres_id")
    private String firmaAdresId;

    @ManyToOne
    @JoinColumn(name = "firma_adres_id" , insertable = false, updatable = false)
    private Adres adres;

    public String getFirmaTelNo() {
        return firmaTelNo;
    }

    public void setFirmaTelNo(String firmaTelNo) {
        this.firmaTelNo = firmaTelNo;
    }

    public long getFirmaId() {
        return firmaId;
    }

    public void setFirmaId(Long firmaId) {
        this.firmaId = firmaId;
    }

    public String getFirmaAd() {
        return firmaAd;
    }

    public void setFirmaAd(String firmaAd) {
        this.firmaAd = firmaAd;
    }

    public String getFirmaAdresId() {
        return firmaAdresId;
    }

    public void setFirmaAdresId(String firmaAdresId) {
        this.firmaAdresId = firmaAdresId;
    }

    public void setFirmaId(long firmaId) {
        this.firmaId = firmaId;
    }
}
