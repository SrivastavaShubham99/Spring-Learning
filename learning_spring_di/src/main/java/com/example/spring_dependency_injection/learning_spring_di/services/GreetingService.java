package com.example.spring_dependency_injection.learning_spring_di.services;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Qualifier("englishLangServiceImpl")
public interface GreetingService {

    public String sayHello();
}
