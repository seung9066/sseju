package com.sseju.java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.sseju.java.**.mapper")
public class SsejuApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsejuApplication.class, args);
	}

}
