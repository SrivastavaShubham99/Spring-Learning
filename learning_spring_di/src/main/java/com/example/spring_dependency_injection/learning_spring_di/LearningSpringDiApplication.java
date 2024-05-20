package com.example.spring_dependency_injection.learning_spring_di;

import com.example.spring_dependency_injection.learning_spring_di.Controller.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LearningSpringDiApplication {

	public static void main(String[] args) {

		// here we are looking for How Spring framework scans all the annotations
		// and creates context for each
		ApplicationContext ctx=SpringApplication.run(LearningSpringDiApplication.class, args);
		MyController controller=ctx.getBean(MyController.class);
		System.out.println("In Main method");
		System.out.println(controller.sayHello());



	}


}
