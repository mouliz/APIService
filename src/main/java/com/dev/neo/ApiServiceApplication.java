package com.dev.neo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration; 

@SpringBootApplication
@Configuration
@ComponentScan({"com.dev.neo","com.dev.neo.controller"})
@EnableAutoConfiguration
public class ApiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiServiceApplication.class, args);
    }
     
    
}
