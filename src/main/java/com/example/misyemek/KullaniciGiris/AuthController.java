package com.example.misyemek.KullaniciGiris;

import com.example.misyemek.entity.Kullanici;
import com.example.misyemek.repository.KullaniciRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final KullaniciRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthController(KullaniciRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login request) {

        Kullanici k = repository.findByKullaniciAdi(request.getKullaniciAdi())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        if (!passwordEncoder.matches(request.getSifre(), k.getKullaniciSifresi())) {
            return ResponseEntity.status(401).body("Kullanıcı adı veya şifre hatalı");
        }

        String accesstoken = jwtService.generateAccessToken(k.getKullaniciAdi(), k.getKullaniciRol());
        String refreshToken = jwtService.generateRefreshToken(k.getKullaniciAdi());
        return ResponseEntity.ok(new AuthResponse(accesstoken,refreshToken));
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody Refresh request){
        String refreshToken = request.getRefreshToken();

        if (!jwtService.isTokenValid(refreshToken)){
            return ResponseEntity.status(401).body("Refresh token geçersiz veya süresi dolmuş");
        }
        String username = jwtService.extractUsername(refreshToken);
        Kullanici k = repository.findByKullaniciAdi(username)
                .orElseThrow(()->new RuntimeException("kullanıcı bulunamadı"));

        String newAccessToken = jwtService.generateAccessToken(k.getKullaniciAdi(),k.getKullaniciRol());

        return ResponseEntity.ok(new AuthResponse(newAccessToken , refreshToken));
    }
}