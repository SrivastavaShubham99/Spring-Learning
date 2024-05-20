package com.example.spring_dependency_injection.learning_spring_di.Controller;


import com.example.spring_dependency_injection.learning_spring_di.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingLangController {


    @Autowired
    @Qualifier("spanishLangServiceImpl")
    private GreetingService greetingService;

    public String sayHello(){
        return greetingService.sayHello();
    }

}
