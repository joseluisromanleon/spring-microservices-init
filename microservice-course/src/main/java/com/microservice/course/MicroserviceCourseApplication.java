package com.microservice.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.microservice.course.client")
@EnableDiscoveryClient  // Cliente de Eureka
@SpringBootApplication
public class MicroserviceCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceCourseApplication.class, args);
    }

}
