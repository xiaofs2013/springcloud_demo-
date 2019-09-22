package com.kgc.springcould.springcould_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer   //启动服务
public class SpringcouldServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcouldServiceApplication.class, args);
    }

}
