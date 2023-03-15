package tobyspring.newhelloboot;

import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RequestMapping("/hello")
//@RestController //디스패처 서블릿과 직접적인 연관은 없음
public class HelloController {

        private final HelloService helloService ;

        public HelloController(HelloService helloService){
            this.helloService = helloService;
        }

        @GetMapping
//        @RequestMapping(value="/hello", method = RequestMethod.GET)
        @ResponseBody //String 으로 리턴하기 위한 애노테이션
        public String hello(String name){ //String으로 리턴하면 디스패처 서블릿은 뷰를 찾음.. 
            return helloService.sayHello(Objects.requireNonNull(name)); // null 이면 에러, 아니면 리턴
    }
}
