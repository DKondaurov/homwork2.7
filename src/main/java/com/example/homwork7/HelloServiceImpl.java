package com.example.homwork7;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    public String speakHello() {
        return "Добро пожаловать";
    }
}
