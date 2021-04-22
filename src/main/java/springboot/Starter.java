package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Starter {
	private static ConfigurableApplicationContext applicationContext;

	public static void main(String[] args) {
		// 获得applicationContext容器
		applicationContext = SpringApplication.run(Starter.class, args);
	}

	public static ConfigurableApplicationContext getApplicationContext() {
		return applicationContext;
	}

}
