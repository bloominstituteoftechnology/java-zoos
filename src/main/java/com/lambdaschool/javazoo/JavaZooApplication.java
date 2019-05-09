package com.lambdaschool.javazoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JavaZooApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(JavaZooApplication.class, args);
	}

}
