package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import app.core.tests.Test;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringJpaDataLesson71Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaDataLesson71Application.class, args);
		Test test = ctx.getBean(Test.class);
		test.testAll();
	}
}
