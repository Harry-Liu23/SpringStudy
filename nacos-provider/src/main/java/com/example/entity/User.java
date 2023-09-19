package com.example.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class User {
    public User(Long id,String username,String name,Integer age, BigDecimal balance) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.age = age;
        this.balance = balance;
    }

    private Long id;

    private String username;

    private String name;

    private Integer age;

    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
