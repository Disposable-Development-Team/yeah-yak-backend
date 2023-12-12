package com.example.yeahyak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class YeahYakApplication {

	public static void main(String[] args) {
		SpringApplication.run(YeahYakApplication.class, args);
	}

}
