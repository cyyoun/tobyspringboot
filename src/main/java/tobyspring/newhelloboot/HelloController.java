package tobyspring.newhelloboot;

import java.util.Objects;

public class HelloController {

        private final HelloService helloService ;

        public HelloController(HelloService helloService){
            this.helloService = helloService;
        }

        public String hello(String name){
            return helloService.sayHello(Objects.requireNonNull(name)); // null 이면 에러, 아니면 리턴
    }
}
