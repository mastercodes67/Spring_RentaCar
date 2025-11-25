package com.batuhanakpinar.rentacar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // <-- SİHİRLİ ANAHTAR BU
public class RentacarSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentacarSpringApplication.class, args);

    }

}
