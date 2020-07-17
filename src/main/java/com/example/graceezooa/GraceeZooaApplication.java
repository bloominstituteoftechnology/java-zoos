package com.example.graceezooa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GraceeZooaApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(GraceeZooaApplication.class, args);
    }

}
