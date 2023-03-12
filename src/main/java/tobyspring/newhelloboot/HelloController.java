package tobyspring.newhelloboot;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello") // URL이 /hello로 들어오는 것과 동시에 http 메서드명이 'GET'이어야 함
    public String hello(String name){
        return "Hello "+name;

    }
}
