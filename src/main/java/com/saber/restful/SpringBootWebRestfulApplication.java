package com.saber.restful;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.saber.restful.mapper")
@SpringBootApplication
public class SpringBootWebRestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebRestfulApplication.class, args);
	}

}
