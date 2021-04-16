package com.example.javazoos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JavaZoosApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(JavaZoosApplication.class,
            args);
    }

}
