package com.xiokary.service.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.xiokary.service.client.UserClient;
import com.xiokary.service.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//@DefaultProperties(defaultFallback = "FallBackMethod") //默认全局熔断方法
@RestController
@RequestMapping("consumer/user")
public class UserController {


    //fein代替
    //http远程服务调用技术
//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient discoveryClient;//包含了拉取的所有服务信息
    @Autowired
    private UserClient userClient;

    @GetMapping
    @ResponseBody
    @HystrixCommand //声明熔断方法
    public String findUserById(@RequestParam("id") Integer id) {
        /*List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
        ServiceInstance serviceInstance = instances.get(0);
        return this.restTemplate.getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/" + id, User.class);*/
//        return this.restTemplate.getForObject("http://service-provider/user/"+id,String.class);
        return this.userClient.findUserById(id).toString();
    }

//    使用fein熔断




//    public String FallBackMethod() {
//        return "服务器正忙。。。";
//
//    }
}
