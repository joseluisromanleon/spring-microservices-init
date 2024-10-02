package com.microservice.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


// indica que es una aplicación de Eureka aunque no es obligatoria.
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceStudentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceStudentsApplication.class, args);
    }

}
