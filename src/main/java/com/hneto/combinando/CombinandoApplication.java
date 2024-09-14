package com.hneto.combinando;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CombinandoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CombinandoApplication.class, args);
	}

}
