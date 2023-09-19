package com.example.nacosconsumer.Controller;

import com.example.nacosconsumer.feign.UserFeign;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class controller {
    @Resource
    private UserFeign userFeign;
    @RequestMapping(value = "users/getUserById/{id}",method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Long id){
        return userFeign.getUser(id);
//        return restTemplate.getForObject("http://microservice-provider-user/users/getUserById/"+id, String.class);
    }


}
