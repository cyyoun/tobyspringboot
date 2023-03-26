package tobyspring.config.autoconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@MyConfigurationProperties
public class ServerProperties {

    /* @Value("${contextPath:}") //없으면 비워둠*/
    private String contex tPath;

    /* @Value("${port:8080}") //port의 프로퍼티 값이 없으면 8080값 사용*/
    private int port;


    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}

