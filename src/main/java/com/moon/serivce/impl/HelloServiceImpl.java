package com.moon.serivce.impl;

import com.moon.serivce.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        if(name == null || name.trim() == "") {
            throw new RuntimeException("paramter is null !!");
        }
        System.out.println("hello "+ name);
    }
}
