package com.xiokary.service.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xiokary.service.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "service-provider",fallback = UserClientFallback.class)
public interface UserClient {

    @GetMapping("user/{id}")
    public User findUserById(@PathVariable("id") Integer id);

}
