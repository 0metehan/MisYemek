package com.example.misyemek.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


@Entity
@Table(name = "kullanıcı")
public class Kullanıcı {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Positive
    @Column(name = "kullanıcı_Id")
    private Long id;

    @NotBlank(message = "Kullanıcı Rol Boş olamaz")
    @Column(name = "kullanıcı_Rol")
    private String kullanıcıRol;

    @NotBlank(message = "Kullanıcı Adı boş olamaz")
    @Column(name = "kullanıcı_Adı")
    private String kullanıcıAdı;

    @NotBlank(message = "Şifre boş olamaz")
    @Column(name = "kullanıcı_Sifresi")
    private String kullanıcıSifresi;

    @NotBlank(message = "Telefon Numarası boş olamaz")
    @Column(name = "kullanıcı_Tel_No")
    private String kullanıcıTelNo;

    public String getKullanıcıRol() {
        return kullanıcıRol;
    }

    public void setKullanıcıRol(String kullanıcıRol) {
        this.kullanıcıRol = kullanıcıRol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKullanıcıAdı() {
        return kullanıcıAdı;
    }

    public void setKullanıcıAdı(String kullanıcıAdı) {
        this.kullanıcıAdı = kullanıcıAdı;
    }

    public String getKullanıcıSifresi() {
        return kullanıcıSifresi;
    }

    public void setKullanıcıSifresi(String kullanıcıSifresi) {
        this.kullanıcıSifresi = kullanıcıSifresi;
    }

    public String getKullanıcıTelNo() {
        return kullanıcıTelNo;
    }

    public void setKullanıcıTelNo(String kullanıcıTelNo) {
        this.kullanıcıTelNo = kullanıcıTelNo;
    }
}
