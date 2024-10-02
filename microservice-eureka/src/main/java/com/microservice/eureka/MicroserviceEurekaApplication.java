package com.microservice.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// etiqueta especial de Eureka para su configuracion y arranque.  servidor de eureka
@EnableEurekaServer
@SpringBootApplication
public class MicroserviceEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceEurekaApplication.class, args);
    }

}
