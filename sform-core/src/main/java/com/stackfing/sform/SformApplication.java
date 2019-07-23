package com.stackfing.sform;

import com.stackfing.sform.beans.annotation.BusniessScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.stackfing.sform.mapper")
@BusniessScan({"com.stackfing.sform.vo", "com.stackfing.sform.entity"})
public class SformApplication {

	public static void main(String[] args) {
		SpringApplication.run(SformApplication.class, args);
	}

}
