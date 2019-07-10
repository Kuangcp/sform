package com.stackfing.sform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.stackfing.sform.mapper")
public class SformApplication {

	public static void main(String[] args) {
		SpringApplication.run(SformApplication.class, args);
	}

}
