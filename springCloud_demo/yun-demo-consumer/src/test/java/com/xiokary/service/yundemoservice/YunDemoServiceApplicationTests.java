package com.xiokary.service.yundemoservice;

import com.xiokary.service.YunDemoServiceApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class YunDemoServiceApplicationTests {

    @Autowired
    private RibbonLoadBalancerClient client;

    @Test
    void contextLoads() {
        for (int i = 0; i < 50; i++) {
            ServiceInstance instance = client.choose("service-provider");
            System.out.println(instance.getHost()+":"+instance.getPort());

        }

    }

}
