package com.example.Micro_Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableMethodSecurity
public class MicroResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroResourceApplication.class, args);
	}

}
