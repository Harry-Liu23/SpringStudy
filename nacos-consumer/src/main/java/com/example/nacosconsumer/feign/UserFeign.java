package com.example.nacosconsumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("microservice-provider-user")
public interface UserFeign {

    @RequestMapping("users/getUserById/{id}")
    String getUser(@PathVariable("id") Long id);
}
