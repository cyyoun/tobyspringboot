package tobyspring.newhelloboot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import tobyspring.config.MySpringBootApplication;

@MySpringBootApplication
public class NewhellobootApplication {
//초기화 작업, container의 어떤 기능을 수행해서 간단하게 확인하고 싶을 때 이 패턴 기억하기
	public static void main(String[] args) {
		SpringApplication.run(NewhellobootApplication.class, args);
	}

}
