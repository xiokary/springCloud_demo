package com.xiokary.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@SpringBootApplication
@EnableZuulProxy//开启zuul组件
@EnableDiscoveryClient//启用客户端
public class YunDemoZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(YunDemoZuulApplication.class, args);
	}

}
