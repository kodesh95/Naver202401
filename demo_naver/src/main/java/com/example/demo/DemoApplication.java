package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages="board.spring.mybatis")
@ComponentScan(basePackages="upload")
@ComponentScan(basePackages="config")
@ComponentScan(basePackages = "websocket")
@ComponentScan(basePackages = "db_jasypt")

//동일 패지키 자동 component-scan
//다른 패키지 설정 추가
//<context:component-scan base-package="board.spring.mybatis" />

@MapperScan(basePackages="board.spring.mybatis")
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("===부트 시작===");
	}

}

