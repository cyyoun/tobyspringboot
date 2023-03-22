package tobyspring.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import tobyspring.config.EnableMyConfiguration;
import tobyspring.config.autoconfig.DispatcherServletConfig;
import tobyspring.config.autoconfig.TomcatWebServerConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) //클래스,인터페이스,이넘에 부여할 수 있음
@Configuration
@ComponentScan
@EnableMyConfiguration //스캔대상 아니더라도 구성정보 추가해서 스캔할 수 있음
public @interface MySpringBootApplication {
}
