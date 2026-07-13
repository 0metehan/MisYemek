package com.example.misyemek.KullaniciGiris;

public class Login {

    private String kullaniciAdi;
    private String sifre;

    public Login() {}

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }


    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}