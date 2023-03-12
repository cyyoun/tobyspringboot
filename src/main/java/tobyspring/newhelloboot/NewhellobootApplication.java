package tobyspring.newhelloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewhellobootApplication {

	public static void main(String[] args) {
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext -> {
//			스프링 컨테이너 만들기
			GenericApplicationContext applicationContext = new GenericApplicationContext();
			applicationContext.registerBean(HelloController.class);
			//HelloService 는 인터페이스이니 정확하게 만들어낼 Bean 클래스를 지정해줘야 함 (Simple)
			applicationContext.registerBean(SimpleHelloService.class);
			applicationContext.refresh();

			servletContext.addServlet("frontcontroller", new HttpServlet() {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					// 인증, 보안, 다국어, 공통 기능
					if(req.getRequestURI().equals("/hello") && req.getMethod().equals((HttpMethod.GET.name()))) {
						String name = req.getParameter("name"); // name 이라는 파라미터 값을 반환해서 저장함

						HelloController helloController = applicationContext.getBean(HelloController.class);
						String ret = helloController.hello(name);

						//서블릿 컨테이너가 에러가 나지 않는 이상 200번 상태코드로 세팅해줘서 리턴해줌
						resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
						resp.getWriter().println(ret);
					}
					else{
						resp.setStatus(HttpStatus.NOT_FOUND.value()); //404 던지는 것
					}

				}
			}).addMapping("/*"); //모든 요청을 다 받게 변경
		});
		webServer.start();

	}

}
