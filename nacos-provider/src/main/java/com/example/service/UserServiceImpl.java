package com.example.service;

import com.example.entity.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public User getUserById(Long id) {
        return new User(id, "Jack", "Jackson", 10, new BigDecimal(1001));
    }
}
