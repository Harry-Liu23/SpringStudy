package com.example.service;

import com.example.entity.User;
//import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
    User getUserById(Long id);
//    int getServPort(HttpServletRequest request);
}
