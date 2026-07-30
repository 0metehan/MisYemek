package com.example.misyemek;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MisYemekApplicationTests {

    @Test
    void sifreHashle() {
        System.out.println(new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder()
                .encode("1234"));   // istediğin şifreyi yaz
    }

}
