package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
        @Select("SELECT * FROM user")
        List<User> getUserList();

        @Select("SELECT * FROM user WHERE id=#{userId}")
        User getUserById(Long userId);

        @Insert("INSERT INTO user (id, username, name, age, balance) VALUES (#{id}, #{userName}, #{name}, #{age},#{balance} )")
        Integer insertUser(Long id,String userName, String name, int age, int balance);

        @Delete("DELETE FROM user WHERE id=#{userId}")
        Integer deleteUserById(Long userId);

        @Update("UPDATE user SET userName=#{userName},name=#{name},age=#{age}, balance=#{balance} WHERE id=#{userId}")
        Integer updateUserById(Long userId, String userName, String name, int age, int balance);


}
