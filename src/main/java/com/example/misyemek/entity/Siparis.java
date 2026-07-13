package com.example.misyemek.entity;

import com.example.misyemek.Enum.SiparisDururmu;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "siparis")
public class Siparis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "siparis_id")
    private Long siparisId;

    @NotNull(message = "sipariş durumu boş olamaz")
    @Enumerated(EnumType.STRING)
    @Column(name = "siparis_durumu")
    private SiparisDururmu siparisDurumu;

    @NotNull(message = "kullanıcı boş olamaz")
    @Column(name = "kullanici_id")
    private Long kullaniciId;

    @CreationTimestamp
    @Column(name = "siparis_tarih_saat")
    private Date tarihSaat;

    @NotNull(message = "adet boş olamaz")
    @Column(name = "adet")
    private Integer adet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "urun_firma_id", referencedColumnName = "firma_urun_id")
    private FirmaUrun firmaUrun;


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

    public Long getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(Long kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public Integer getAdet() {
        return adet;
    }

    public void setAdet(Integer adet) {
        this.adet = adet;
    }

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
}
