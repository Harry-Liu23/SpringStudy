package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.dao.UserMapper;
import com.example.entity.User;
import com.example.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("addData/{key}+{value}")
    public Object addData(@PathVariable("key")String key, @PathVariable("value")String value){
        redisTemplate.opsForValue().set(key,value);
        System.out.println(redisTemplate);
        return redisTemplate;
    }


    @RequestMapping("users/getUserById/{id}")
    public String getUserById(@PathVariable("id") Long id) {
        return JSON.toJSONString(userMapper.getUserById(id));
//        return "ok";
    }

    @RequestMapping("users/getAllUsers")
    public String getAllUsers() {
        return userMapper.getUserList().toString();
    }

    @RequestMapping("users/insertUser/{id}+{username}+{name}+{age}+{balance}")
    public String insertUser(@PathVariable("id") Long id,
                             @PathVariable("username")String username,
                             @PathVariable("name")String name,
                             @PathVariable("age")int age,
                             @PathVariable("balance")int balance){
        userMapper.insertUser(id,username,name,age,balance);
        return userMapper.getUserById(id).toString()+"\n"+userMapper.getUserList().toString();
    }

    @RequestMapping("users/deleteUsers/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        try{
            userMapper.deleteUserById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Removed!"+"\n"+userMapper.getUserList().toString();
    }

    @RequestMapping("users/updateUsers/{id}+{username}+{name}+{age}+{balance}")
    public String updateUser(@PathVariable("id") Long id,
                             @PathVariable("username")String username,
                             @PathVariable("name")String name,
                             @PathVariable("age")int age,
                             @PathVariable("balance")int balance){
        userMapper.updateUserById(id,username,name,age,balance);
        return userMapper.getUserList().toString();

    }
}
