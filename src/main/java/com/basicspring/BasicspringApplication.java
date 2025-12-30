package com.basicspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BasicspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicspringApplication.class, args);
    }

}
