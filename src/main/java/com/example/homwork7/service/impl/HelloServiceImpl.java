package com.example.homwork7.service.impl;

import com.example.homwork7.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    public String speakHello() {
        return "Добро пожаловать";
    }
}
