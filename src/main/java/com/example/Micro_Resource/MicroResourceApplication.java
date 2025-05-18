package com.example.Micro_Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class MicroResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroResourceApplication.class, args);
	}

}
