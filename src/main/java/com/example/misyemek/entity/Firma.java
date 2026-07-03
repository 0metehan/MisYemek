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
    @Column(name = "firma_ID")
    private long firmaId;

    @NotBlank(message = "Firma Adı boş olamaz")
    @Column(name = "firma_Adı" )
    private String firmaAd;

    @NotBlank(message = "Firma Telefon no boş olamaz")
    @Column(name = "firma_Tel_No")
    private String firmaTelNo;


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

}
