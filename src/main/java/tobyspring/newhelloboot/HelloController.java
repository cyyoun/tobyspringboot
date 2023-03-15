package tobyspring.newhelloboot;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


//@Controller //메타 애노테이션 (Component 포함)
@RestController //Controller, ResponseBody 가지고 있는 메타 애노테이션 (api)
public class HelloController {

        private final HelloService helloService ;
        private final ApplicationContext applicationContext;

        public HelloController(HelloService helloService, ApplicationContext applicationContext){
            this.helloService = helloService;
            this.applicationContext = applicationContext;
        }

        @GetMapping("/hello")
//        @RequestMapping(value="/hello", method = RequestMethod.GET)
        public String hello(String name){ //String으로 리턴하면 디스패처 서블릿은 뷰를 찾음..
            return helloService.sayHello(Objects.requireNonNull(name)); // null 이면 에러, 아니면 리턴
    }
}
