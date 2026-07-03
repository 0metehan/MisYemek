package com.example.misyemek.entity;

import com.example.misyemek.Enum.SiparisDururmu;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "siparis")
public class Sipariş {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "siparis_Id")
    private Long siparisId;

    @NotNull(message = "sipariş durumu boş olamaz")
    @Enumerated(EnumType.STRING)
    @Column(name = "siparis_durumu")
    private SiparisDururmu siparisDurumu;

    @NotNull(message = "kullanıcı boş olamaz")
    @Column(name = "kullanıcı_Id")
    private Long kullanıcıId;

    @CreationTimestamp
    @Column(name = "siparis_tarih_saat")
    private Date tarihSaat;

    @NotNull(message = "adet boş olamaz")
    @Column(name = "adet")
    private Integer adet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "urun_firma_Id", referencedColumnName = "Urun_Firma_Id")
    private FirmaUrun firmaUrun;

    public Date getTarihSaat() {
        return tarihSaat;
    }

    public void setTarihSaat(Date tarihSaat) {
        this.tarihSaat = tarihSaat;
    }

    public FirmaUrun getFirmaUrun() {
        return firmaUrun;
    }

    public void setFirmaUrun(FirmaUrun firmaUrun) {
        this.firmaUrun = firmaUrun;
    }

    public Long getKullanıcıId() {
        return kullanıcıId;
    }

    public void setKullanıcıId(Long kullanıcıId) {
        this.kullanıcıId = kullanıcıId;
    }

    public Long getSiparisId() {
        return siparisId;
    }

    public void setSiparisId(Long siparisId) {
        this.siparisId = siparisId;
    }

    public SiparisDururmu getSiparisDurumu() {
        return siparisDurumu;
    }

    public void setSiparisDurumu(SiparisDururmu siparisDurumu) {
        this.siparisDurumu = siparisDurumu;
    }

    public Integer getAdet() {
        return adet;
    }

    public void setAdet(Integer adet) {
        this.adet = adet;
    }
}
