package com.example.misyemek.KullaniciGiris;

public class AuthResponse {

    private String accessToken;
    private String refreshToken;
    private Long kullaniciId;

    public AuthResponse(String accessToken ,String refreshToken, Long kullaniciId ){
        this.accessToken=accessToken;
        this.refreshToken=refreshToken;
        this.kullaniciId=kullaniciId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public Long getKullaniciId() {
        return kullaniciId;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
