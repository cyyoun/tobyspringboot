package tobyspring.newhelloboot;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary //HelloController가 필요한 bean이 2개가 존재할 떄 우선순위를 높여줌
//상속
public class HelloDecorator implements HelloService{
    private final HelloService helloService;

    //주입
    public HelloDecorator(HelloService helloService){
        this.helloService = helloService;
    }
    @Override
    public String sayHello(String name) {
        return "*"+helloService.sayHello(name)+"*";
    }
}
