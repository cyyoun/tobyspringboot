package tobyspring.newhelloboot;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {
    public static void	run	(Class<?> applicationClass, String... args){
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext(){
            @Override
            protected void onRefresh() {
                super.onRefresh();

                ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
                DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
                dispatcherServlet.setApplicationContext(this); //-> 이 소스가 없어도 Spring Container 가 알아서 ApplicationContext를 주입해줌

                WebServer webServer = serverFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("disspatcherServlet", dispatcherServlet).addMapping("/*"); //모든 요청을 다 받게 변경
                });
                webServer.start();
            }
        };
        applicationContext.register(applicationClass);
        applicationContext.refresh();
    }
}
