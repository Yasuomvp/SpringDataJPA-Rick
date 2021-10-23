package com.rick.springdatajparick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.rick")
public class SpringDataJpaRickApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaRickApplication.class, args);
    }



}
