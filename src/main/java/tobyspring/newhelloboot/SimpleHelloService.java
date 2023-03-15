package tobyspring.newhelloboot;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service //메타 애노테이션 (Component 포함)
public class SimpleHelloService implements HelloService {
    @Override
    public String sayHello(String name){
        return "Hello "+name;
    }
}
