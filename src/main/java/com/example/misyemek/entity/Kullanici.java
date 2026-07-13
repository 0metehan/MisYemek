package com.example.misyemek.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


@Entity
@Table(name = "kullanici")
public class Kullanici {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Positive
    @Column(name = "kullanici_id")
    private Long id;

    @NotBlank(message = "Kullanıcı Rol Boş olamaz")
    @Column(name = "kullanici_rol")
    private String kullaniciRol;

    @NotBlank(message = "Kullanıcı Adı boş olamaz")
    @Column(name = "kullanici_adi")
    private String kullaniciAdi;

    @NotBlank(message = "Şifre boş olamaz")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "kullanici_sifresi" , length = 255)
    private String kullaniciSifresi;

    @NotBlank(message = "Telefon Numarası boş olamaz")
    @Column(name = "kullanici_tel_no")
    private String kullaniciTelNo;

    @Column(name = "kullanici_adres_id")
    private Long kullaniciAdresId;

    @ManyToOne
    @JoinColumn(name="kullanici_adres_id", insertable = false, updatable = false)
    private Adres adres;


    public void setKullaniciRol(String kullaniciRol) {
        this.kullaniciRol = kullaniciRol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKullaniciRol() {
        return kullaniciRol;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getKullaniciSifresi() {
        return kullaniciSifresi;
    }

    public void setKullaniciSifresi(String kullaniciSifresi) {
        this.kullaniciSifresi = kullaniciSifresi;
    }

    public String getKullaniciTelNo() {
        return kullaniciTelNo;
    }

    public void setKullaniciTelNo(String kullaniciTelNo) {
        this.kullaniciTelNo = kullaniciTelNo;
    }

    public Long getKullaniciAdresId() {
        return kullaniciAdresId;
    }

    public void setKullaniciAdresId(Long kullaniciAdresId) {
        this.kullaniciAdresId = kullaniciAdresId;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
}
