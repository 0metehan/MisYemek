package com.example.misyemek.Service;

import com.example.misyemek.entity.FirmaSahibi;
import com.example.misyemek.repository.FirmaSahibiRepository;
import org.springframework.stereotype.Service;

@Service
public class FirmaSahibiService {

    private final FirmaSahibiRepository repository;

    public FirmaSahibiService(FirmaSahibiRepository repository) {
        this.repository = repository;
    }

    public FirmaSahibi firmaSahibiGetir(Long kullaniciId){
        return repository.firmaSahibiGetir(kullaniciId);
    }
}
