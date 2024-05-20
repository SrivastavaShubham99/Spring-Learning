package com.example.spring_dependency_injection.learning_spring_di.services;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Service
public class SpanishLangServiceImpl implements GreetingService{
    @Override
    public String sayHello() {
        return "Hello from the spanish side !!!!";
    }
}
