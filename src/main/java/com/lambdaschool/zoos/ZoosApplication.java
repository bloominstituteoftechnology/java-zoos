package com.lambdaschool.zoos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ZoosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZoosApplication.class, args);
    }

}
