package com.example.spring_dependency_injection.learning_spring_di.services;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;



// @Primary annotation basically differentitates that which service we have to use
/*
In Spring Framework, primary annotation usage typically refers to the @Primary annotation,
which is used to give a higher preference to a specific bean when multiple beans of the same type are present.
This is particularly useful in dependency injection scenarios where you want to specify a default
bean to be injected when multiple candidates are available.

@Primary: Specifies the default bean to use when multiple beans of the same type exist.
@Qualifier: Used to specify which bean to inject explicitly when needed.


 */


@Primary
@Service
public class EnglishLangServiceImpl implements GreetingService{
    @Override
    public String sayHello() {
        return "Hello from the English side !!!!!";
    }
}
