package com.example.synchronizationtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RemoteService {
    public static void main(String[] args) {
        // 이미 작성된 application.properties 설정값 말고 다른 것을
        // 쓰고 싶다면 아래처럼 System.setProperty 를 사용하면 된다.
        System.setProperty("server.port", "8081");
        SpringApplication.run(RemoteService.class, args);
    }
}
