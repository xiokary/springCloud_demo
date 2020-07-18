package com.xiokary.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //启动eureka服务段组件
public class YunDemoEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(YunDemoEurekaApplication.class, args);
    }

}
