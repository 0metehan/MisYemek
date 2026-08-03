package com.example.misyemek.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "bildirim")
public class Bildirim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bildirim_id")
    private Long bildirimId;

    @Column(name = "bildirim_metni")
    private String bildirimMetni;

    @Column(name = "bildirim_tarih")
    private Date bildirimTarih;

    @Column(name ="kullanici_id")
    private Long kullaniciId;

    public String getBildirimMetni() {
        return bildirimMetni;
    }

    public void setBildirimMetni(String bildirimMetni) {
        this.bildirimMetni = bildirimMetni;
    }

    public Long getBildirimId() {
        return bildirimId;
    }

    public void setBildirimId(Long bildirimId) {
        this.bildirimId = bildirimId;
    }

    public Date getBildirimTarih() {
        return bildirimTarih;
    }

    public void setBildirimTarih(Date bildirimTarih) {
        this.bildirimTarih = bildirimTarih;
    }

    public Long getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(Long kullaniciId) {
        this.kullaniciId = kullaniciId;
    }
}
