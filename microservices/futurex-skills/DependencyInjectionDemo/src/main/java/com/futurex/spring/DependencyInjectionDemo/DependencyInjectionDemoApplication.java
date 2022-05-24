package com.futurex.spring.DependencyInjectionDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionDemoApplication {

	public static void main(String[] args) {
		System.out.println("This is Dependency Injection Demo Application");
		/*SpringApplication.run(DependencyInjectionDemoApplication.class, args);

		Animal animal = new Cat();
		AnimalSpeak as = new AnimalSpeak();
		as.setAnimal(animal);
		as.makeAnimalSpeak();*/

		ApplicationContext appContext = SpringApplication.run(DependencyInjectionDemoApplication.class, args);

		//Animal animal = appContext.getBean(Animal.class);
		AnimalSpeak as = appContext.getBean(AnimalSpeak.class);
		as.makeAnimalSpeak();
	}

}
