package dev.ldkstellar.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class DemoApplication {

	public static void main(String[] args) {

		TestInterface testInterface = new TestImplementation();
		TestComponent testComponent = new TestComponent(testInterface);


		SpringApplication.run(DemoApplication.class, args);
	}

}
