package com.uptc.frw.aparatoselectronicos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AparatosElectronicosApplication {

    public static void main(String[] args) {
        SpringApplication.run(AparatosElectronicosApplication.class, args);

    }

}
