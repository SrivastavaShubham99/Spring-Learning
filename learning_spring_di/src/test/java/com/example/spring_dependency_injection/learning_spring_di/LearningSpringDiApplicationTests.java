package com.example.spring_dependency_injection.learning_spring_di;

import com.example.spring_dependency_injection.learning_spring_di.Controller.GreetingLangController;
import com.example.spring_dependency_injection.learning_spring_di.services.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@SpringBootTest
class LearningSpringDiApplicationTests {


	@Autowired
	private GreetingLangController greetingLangController;



	@Test
	void testLang() {
		System.out.println(greetingLangController.sayHello());
	}

}
