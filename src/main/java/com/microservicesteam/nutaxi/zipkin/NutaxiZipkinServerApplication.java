package com.microservicesteam.nutaxi.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

@SpringBootApplication
@EnableZipkinStreamServer
public class NutaxiZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NutaxiZipkinServerApplication.class, args);
    }
}
