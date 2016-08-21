package com.microservicesteam.nutaxi.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NutaxiZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NutaxiZipkinServerApplication.class, args);
    }
}
